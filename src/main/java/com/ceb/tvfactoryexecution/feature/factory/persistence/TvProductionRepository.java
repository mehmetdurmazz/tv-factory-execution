package com.ceb.tvfactoryexecution.feature.factory.persistence;

import com.ceb.tvfactoryexecution.feature.factory.model.TvProduction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvProductionRepository extends CrudRepository<TvProduction, Long> {
}
