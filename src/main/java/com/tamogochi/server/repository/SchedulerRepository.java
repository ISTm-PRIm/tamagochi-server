package com.tamogochi.server.repository;

import com.tamogochi.server.entity.Indicator;
import com.tamogochi.server.entity.Scheduler;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface SchedulerRepository extends CrudRepository<Scheduler, Integer> {
    List<Scheduler> getAllByIndicator(Indicator indicator);
}
