package com.ceb.tvfactoryexecution.feature.factory.service;

import com.ceb.tvfactoryexecution.feature.factory.dto.PanelDto;
import com.ceb.tvfactoryexecution.feature.factory.dto.PanelDtoMapper;
import com.ceb.tvfactoryexecution.feature.factory.exception.ActionCancelledException;
import com.ceb.tvfactoryexecution.feature.factory.model.Panel;
import com.ceb.tvfactoryexecution.feature.factory.persistence.PanelRepository;
import com.ceb.tvfactoryexecution.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Service
public class PanelService extends Action {

    private final PanelRepository panelRepository;

    private final PanelDtoMapper mapper;

    public PanelDto buildPanel(String robot, AtomicInteger totalNumberOfRobot) throws ActionCancelledException {
        String message = robot + ": panel building";
        log.info(message);
        keepBusy();

        cancelActionWhenGameIsOver(totalNumberOfRobot, message);

        return mapper.map(panelRepository.save(Panel.builder()
                .panelBarcode(UUID.randomUUID())
                .producedBy(robot)
                .build()));
    }

    public void removePanelFromStock(long id) {
        panelRepository.deleteById(id);
    }

    @Override
    protected void keepBusy() {
        try {
            Thread.sleep(Utils.PANEL_BUILDING_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
