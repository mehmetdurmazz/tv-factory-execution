package com.ceb.tvfactoryexecution.feature.factory;

import com.ceb.tvfactoryexecution.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Service
public class TVFactoryExecutor {

    private final TVProducer tvProducer;

    @Async
    public void execute() {
        AtomicInteger totalNumberOfRobots = new AtomicInteger(2);
        AtomicInteger totalRevenue = new AtomicInteger(0);
        int numberOfRobotInUse = 2;

        tvProducer.produce(Utils.createRobotId(1), totalNumberOfRobots, totalRevenue);
        tvProducer.produce(Utils.createRobotId(2), totalNumberOfRobots, totalRevenue);

        while(!Utils.isProductionEnd(totalNumberOfRobots.get())) {
            if(totalNumberOfRobots.get() > numberOfRobotInUse) {
                while (!Utils.isProductionEnd(totalNumberOfRobots.get()) && numberOfRobotInUse < totalNumberOfRobots.get()) {
                    tvProducer.produce(Utils.createRobotId(++numberOfRobotInUse), totalNumberOfRobots, totalRevenue);
                }
            }
        }
    }
}
