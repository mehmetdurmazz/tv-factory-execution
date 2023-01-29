package com.ceb.tvfactoryexecution.feature.factory.dto;

import com.ceb.tvfactoryexecution.feature.factory.model.Sales;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-29T10:20:55+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class SalesDtoMapperImpl implements SalesDtoMapper {

    @Override
    public SalesDto map(Sales sales) {
        if ( sales == null ) {
            return null;
        }

        SalesDto salesDto = new SalesDto();

        if ( sales.getId() != null ) {
            salesDto.setId( sales.getId() );
        }
        salesDto.setPrice( sales.getPrice() );
        salesDto.setSoldBy( sales.getSoldBy() );

        return salesDto;
    }
}
