package com.ceb.tvfactoryexecution.feature.factory.persistence;

import com.ceb.tvfactoryexecution.feature.factory.model.MainBoard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainBoardRepository extends CrudRepository<MainBoard, Long> {
}
