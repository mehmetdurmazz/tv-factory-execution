package com.ceb.tvfactoryexecution.feature.factory.dto;

import lombok.Data;

@Data
public class SalesDto {

    private long id;

    private long tvId;

    private int price;

    private String soldBy;
}
