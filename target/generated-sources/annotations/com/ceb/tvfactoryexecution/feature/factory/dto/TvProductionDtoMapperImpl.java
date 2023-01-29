package com.ceb.tvfactoryexecution.feature.factory.dto;

import com.ceb.tvfactoryexecution.feature.factory.model.TvProduction;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-29T10:20:55+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class TvProductionDtoMapperImpl implements TvProductionDtoMapper {

    @Override
    public TvProductionDto map(TvProduction tvProduction) {
        if ( tvProduction == null ) {
            return null;
        }

        TvProductionDto tvProductionDto = new TvProductionDto();

        tvProductionDto.setId( tvProduction.getId() );
        tvProductionDto.setPanelBarcode( tvProduction.getPanelBarcode() );
        tvProductionDto.setMainBoardBarcode( tvProduction.getMainBoardBarcode() );
        tvProductionDto.setAssembledBy( tvProduction.getAssembledBy() );

        return tvProductionDto;
    }
}
