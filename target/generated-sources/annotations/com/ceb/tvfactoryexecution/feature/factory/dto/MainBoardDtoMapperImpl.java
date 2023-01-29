package com.ceb.tvfactoryexecution.feature.factory.dto;

import com.ceb.tvfactoryexecution.feature.factory.model.MainBoard;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-29T10:20:55+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class MainBoardDtoMapperImpl implements MainBoardDtoMapper {

    @Override
    public MainBoardDto map(MainBoard mainBoard) {
        if ( mainBoard == null ) {
            return null;
        }

        MainBoardDto mainBoardDto = new MainBoardDto();

        mainBoardDto.setId( mainBoard.getId() );
        mainBoardDto.setMainBoardBarcode( mainBoard.getMainBoardBarcode() );
        mainBoardDto.setProducedBy( mainBoard.getProducedBy() );

        return mainBoardDto;
    }
}
