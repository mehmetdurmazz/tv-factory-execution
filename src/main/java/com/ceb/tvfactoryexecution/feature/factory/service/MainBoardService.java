package com.ceb.tvfactoryexecution.feature.factory.service;

import com.ceb.tvfactoryexecution.feature.factory.dto.MainBoardDto;
import com.ceb.tvfactoryexecution.feature.factory.dto.MainBoardDtoMapper;
import com.ceb.tvfactoryexecution.feature.factory.exception.ActionCancelledException;
import com.ceb.tvfactoryexecution.feature.factory.model.MainBoard;
import com.ceb.tvfactoryexecution.feature.factory.persistence.MainBoardRepository;
import com.ceb.tvfactoryexecution.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Service
public class MainBoardService extends Action {

    private final MainBoardRepository mainBoardRepository;

    private final MainBoardDtoMapper mapper;

    public MainBoardDto buildMainBoard(String robot, AtomicInteger totalNumberOfRobot) throws ActionCancelledException {
        String message = robot + ": main board building";
        log.info(message);
        keepBusy();

        cancelActionWhenGameIsOver(totalNumberOfRobot, message);

        return mapper.map(mainBoardRepository.save(MainBoard.builder()
                .mainBoardBarcode(UUID.randomUUID())
                .producedBy(robot)
                .build()));
    }

    @Override
    protected void keepBusy() {
        try {
            Thread.sleep(Utils.MAIN_BOARD_BUILDING_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
