package com.tamogochi.server.service.api;

import com.tamogochi.server.entity.UpdateHistory;

import java.util.List;

public interface SchedulerService {
    List<UpdateHistory> createHistoriesForScheduler();
}
