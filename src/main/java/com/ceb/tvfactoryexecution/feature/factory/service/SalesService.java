package com.ceb.tvfactoryexecution.feature.factory.service;

import com.ceb.tvfactoryexecution.feature.factory.dto.SalesDto;
import com.ceb.tvfactoryexecution.feature.factory.exception.ActionCancelledException;
import com.ceb.tvfactoryexecution.feature.factory.helper.SalesServiceHelper;
import com.ceb.tvfactoryexecution.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Service
public class SalesService extends Action {

    private final SalesServiceHelper salesServiceHelper;

    public SalesDto sellTV(String robot, long tvId, int price, AtomicInteger totalNumberOfRobot) throws ActionCancelledException {
        String message = robot + ": TV with id " + tvId + " is being sold for " + price + " EUR";
        log.info(message);
        keepBusy();

        cancelActionWhenGameIsOver(totalNumberOfRobot, message);
        return salesServiceHelper.saveSales(robot, price, tvId);
    }

    public void calculateTotalRevenueAfterSale(AtomicInteger totalRevenue, int price) {
        totalRevenue.addAndGet(price);
    }

    @Override
    protected void keepBusy() {
        try {
            Thread.sleep(Utils.SALES_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
