package com.ceb.tvfactoryexecution.feature.factory.dto;

import com.ceb.tvfactoryexecution.feature.factory.model.TvProduction;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TvProductionDtoMapper {

    TvProductionDto map(TvProduction tvProduction);
}
