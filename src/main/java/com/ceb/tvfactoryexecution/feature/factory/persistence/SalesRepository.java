package com.ceb.tvfactoryexecution.feature.factory.persistence;

import com.ceb.tvfactoryexecution.feature.factory.model.Sales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends CrudRepository<Sales, Long> {
}
