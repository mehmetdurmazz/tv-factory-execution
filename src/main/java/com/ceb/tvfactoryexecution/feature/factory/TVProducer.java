package com.ceb.tvfactoryexecution.feature.factory;

import com.ceb.tvfactoryexecution.feature.factory.dto.MainBoardDto;
import com.ceb.tvfactoryexecution.feature.factory.exception.ActionCancelledException;
import com.ceb.tvfactoryexecution.feature.factory.service.*;
import com.ceb.tvfactoryexecution.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Service
public class TVProducer {

    private final PanelService panelService;

    private final MainBoardService mainBoardService;

    private final TVProductionService TVProductionService;

    private final SalesService salesService;

    private final RobotService robotService;

    @Async
    public void produce(String robot, AtomicInteger totalNumberOfRobot, AtomicInteger totalRevenue) {
        Optional<MainBoardDto> mainBoardToUse = Optional.empty();

        while (!Utils.isProductionEnd(totalNumberOfRobot.get())) {
            try {
                var buiiltPanelDto = panelService.buildPanel(robot, totalNumberOfRobot);

                if(mainBoardToUse.isEmpty()) {
                    waitToSwitchAnotherAction();
                    mainBoardToUse = Optional.of(mainBoardService.buildMainBoard(robot, totalNumberOfRobot));
                }

                waitToSwitchAnotherAction();

                var product = TVProductionService.assembleTV(robot, buiiltPanelDto.getPanelBarcode(),
                        mainBoardToUse.get().getMainBoardBarcode(), totalNumberOfRobot);
                if(product.isEmpty()) {
                    panelService.removePanelFromStock(buiiltPanelDto.getId());
                    continue;
                }

                waitToSwitchAnotherAction();

                var soldTv =  salesService.sellTV(robot, product.get().getId(), Utils.TV_PRICE, totalNumberOfRobot);
                salesService.calculateTotalRevenueAfterSale(totalRevenue, soldTv.getPrice());

                waitToSwitchAnotherAction();

                robotService.buyNewRobot(robot, totalNumberOfRobot, totalRevenue);

                mainBoardToUse = Optional.empty();
            } catch (ActionCancelledException e) {
                log.warn("Game over, action cancelled: " + e.getMessage());
            }
        }
    }

    private void waitToSwitchAnotherAction() {
        try {
            Thread.sleep(Utils.ACTION_SWITCH_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
