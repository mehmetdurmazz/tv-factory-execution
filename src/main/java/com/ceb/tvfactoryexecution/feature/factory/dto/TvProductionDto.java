package com.ceb.tvfactoryexecution.feature.factory.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class TvProductionDto {

    private long id;

    private UUID panelBarcode;

    private UUID mainBoardBarcode;

    private String assembledBy;
}
