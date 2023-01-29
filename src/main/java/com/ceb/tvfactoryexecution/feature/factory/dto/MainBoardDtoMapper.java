package com.ceb.tvfactoryexecution.feature.factory.dto;

import com.ceb.tvfactoryexecution.feature.factory.model.MainBoard;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MainBoardDtoMapper {

    MainBoardDto map(MainBoard mainBoard);
}
