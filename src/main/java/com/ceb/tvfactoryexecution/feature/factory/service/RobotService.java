package com.ceb.tvfactoryexecution.feature.factory.service;

import com.ceb.tvfactoryexecution.feature.factory.exception.ActionCancelledException;
import com.ceb.tvfactoryexecution.feature.factory.model.Robot;
import com.ceb.tvfactoryexecution.feature.factory.persistence.RobotRepository;
import com.ceb.tvfactoryexecution.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Service
public class RobotService extends Action {

    private final RobotRepository robotRepository;

    public void buyNewRobot(String robot, AtomicInteger totalNumberOfRobot, AtomicInteger totalRevenue) throws ActionCancelledException {
        if(totalRevenue.get() >= Utils.ROBOT_PRICE) {
            String message = robot + ": a new robot purchasing";
            log.info(message);

            keepBusy();
            cancelActionWhenGameIsOver(totalNumberOfRobot, message);

            totalRevenue.addAndGet(-Utils.ROBOT_PRICE);
            robotRepository.save(Robot.builder()
                    .name(Utils.createRobotId(totalNumberOfRobot.addAndGet(1)))
                    .buyer(robot)
                    .build());

            log.info(robot + ": a new robot purchased");
        }
    }

    @Override
    protected void keepBusy() {
        try {
            Thread.sleep(Utils.ROBOT_BUYING_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
