package com.ceb.tvfactoryexecution.feature.factory.service;

import com.ceb.tvfactoryexecution.feature.factory.exception.ActionCancelledException;
import com.ceb.tvfactoryexecution.utils.Utils;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Action {

    protected abstract void keepBusy();

    protected void cancelActionWhenGameIsOver(AtomicInteger totalNumberOfRobot, String message) throws ActionCancelledException {
        if (Utils.isProductionEnd(totalNumberOfRobot.get()))
            throw new ActionCancelledException(message);
    }

}
