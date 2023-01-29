package com.ceb.tvfactoryexecution.feature.factory.persistence;

import com.ceb.tvfactoryexecution.feature.factory.model.Panel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelRepository extends CrudRepository<Panel, Long> {
}
