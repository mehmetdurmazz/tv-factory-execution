package com.ceb.tvfactoryexecution.feature.factory.service;

import com.ceb.tvfactoryexecution.feature.factory.dto.TvProductionDto;
import com.ceb.tvfactoryexecution.feature.factory.dto.TvProductionDtoMapper;
import com.ceb.tvfactoryexecution.feature.factory.exception.ActionCancelledException;
import com.ceb.tvfactoryexecution.feature.factory.model.TvProduction;
import com.ceb.tvfactoryexecution.feature.factory.persistence.TvProductionRepository;
import com.ceb.tvfactoryexecution.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Service
public class TVProductionService extends Action {

    private final TvProductionRepository tvProductionRepository;

    private final TvProductionDtoMapper mapper;

    public Optional<TvProductionDto> assembleTV(String robot, UUID panelBarcode, UUID mainBoardBarcode, AtomicInteger totalNumberOfRobot) throws ActionCancelledException {
        if (!amILucky()) {
            log.warn(robot + ": TV could not be assembled. Panel " + panelBarcode + " removing");
            return Optional.empty();
        }

        String message = robot + ": TV assembling";
        log.info(message);
        keepBusy();

        cancelActionWhenGameIsOver(totalNumberOfRobot, message);

        var tvProduction = TvProduction.builder()
                .panelBarcode(panelBarcode)
                .mainBoardBarcode(mainBoardBarcode)
                .assembledBy(robot)
                .build();

        return Optional.of(mapper.map(tvProductionRepository.save(tvProduction)));
    }

    public Optional<TvProduction> getTvById(long id) {
        return tvProductionRepository.findById(id);
    }

    private boolean amILucky() {
        return new Random().nextInt(1, 101) <= 60;
    }

    @Override
    protected void keepBusy() {
        try {
            Thread.sleep(Utils.ASSEMBLING_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
