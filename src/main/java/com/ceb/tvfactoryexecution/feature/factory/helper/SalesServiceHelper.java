package com.ceb.tvfactoryexecution.feature.factory.helper;

import com.ceb.tvfactoryexecution.feature.factory.dto.SalesDto;
import com.ceb.tvfactoryexecution.feature.factory.dto.SalesDtoMapper;
import com.ceb.tvfactoryexecution.feature.factory.model.Sales;
import com.ceb.tvfactoryexecution.feature.factory.persistence.SalesRepository;
import com.ceb.tvfactoryexecution.feature.factory.service.TVProductionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// Helper class to keep transaction short

@RequiredArgsConstructor
@Component
public class SalesServiceHelper {

    private final SalesRepository salesRepository;

    private final TVProductionService tvProductionService;

    private final SalesDtoMapper mapper;

    @Transactional
    public SalesDto saveSales(String robot, int price, long tvId) {
        var newSaleRecord =  salesRepository.save(Sales.builder()
                .tvProduction(tvProductionService.getTvById(tvId).orElseThrow())
                .price(price)
                .soldBy(robot)
                .build());

        return mapper.map(newSaleRecord);
    }
}
