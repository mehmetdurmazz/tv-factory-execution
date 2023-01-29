package com.ceb.tvfactoryexecution.feature.factory.dto;

import com.ceb.tvfactoryexecution.feature.factory.model.Panel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-29T10:20:55+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class PanelDtoMapperImpl implements PanelDtoMapper {

    @Override
    public PanelDto map(Panel panel) {
        if ( panel == null ) {
            return null;
        }

        PanelDto panelDto = new PanelDto();

        panelDto.setId( panel.getId() );
        panelDto.setPanelBarcode( panel.getPanelBarcode() );
        panelDto.setProducedBy( panel.getProducedBy() );

        return panelDto;
    }
}
