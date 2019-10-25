package com.tamogochi.server.repository;

import com.tamogochi.server.entity.Indicator;
import com.tamogochi.server.entity.Scheduler;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedulerRepository extends CrudRepository<Scheduler, Integer> {
    List<Scheduler> getAllByIndicator(Indicator indicator);
}
