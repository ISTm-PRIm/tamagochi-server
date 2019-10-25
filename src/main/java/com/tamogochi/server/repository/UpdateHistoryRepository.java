package com.tamogochi.server.repository;

import com.tamogochi.server.entity.UpdateHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateHistoryRepository extends CrudRepository<UpdateHistory, Integer> {
}
