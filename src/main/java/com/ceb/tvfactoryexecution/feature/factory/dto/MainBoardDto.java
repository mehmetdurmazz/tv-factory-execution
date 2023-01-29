package com.ceb.tvfactoryexecution.feature.factory.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MainBoardDto {

    private long id;

    private UUID mainBoardBarcode;

    private String producedBy;
}
