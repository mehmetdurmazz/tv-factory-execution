package com.ceb.tvfactoryexecution.feature.factory.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PanelDto {

    private long id;

    private UUID panelBarcode;

    private String producedBy;
}
