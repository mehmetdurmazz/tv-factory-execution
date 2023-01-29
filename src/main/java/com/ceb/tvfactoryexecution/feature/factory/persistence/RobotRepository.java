package com.ceb.tvfactoryexecution.feature.factory.persistence;

import com.ceb.tvfactoryexecution.feature.factory.model.Robot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobotRepository extends CrudRepository<Robot, Long> {
}
