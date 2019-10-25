package com.tamogochi.server.service.impl;

import com.tamogochi.server.entity.Pet;
import com.tamogochi.server.entity.Scheduler;
import com.tamogochi.server.entity.UpdateHistory;
import com.tamogochi.server.repository.SchedulerRepository;
import com.tamogochi.server.repository.UpdateHistoryRepository;
import com.tamogochi.server.service.api.PetService;
import com.tamogochi.server.service.api.SchedulerService;
import com.tamogochi.server.entity.Indicator;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("schedulerService")
public class SchedulerServiceImpl implements SchedulerService {

    private final PetService petService;
    private final SchedulerRepository schedulerRepository;
    private final UpdateHistoryRepository historyRepository;

    public SchedulerServiceImpl(PetService petService,
                                SchedulerRepository schedulerRepository,
                                UpdateHistoryRepository historyRepository) {
        this.petService = petService;
        this.schedulerRepository = schedulerRepository;
        this.historyRepository = historyRepository;
    }

    /**
     * проверяет, есть ли у индикатора подходящие под текущее время конфиги - если есть, возвращает самый высокий по приоритету
     *
     * @param indicator            Показатель, для которого ищется планировщник
     * @param currentLocalDateTime Текущее время
     * @return Подходящий конфиг
     */
    private Scheduler getSuitableScheduledConfig(Indicator indicator, LocalDateTime currentLocalDateTime) {
        Scheduler trueConfig = new Scheduler();
        List<Scheduler> configs = schedulerRepository.getAllByIndicator(indicator);
        List<Scheduler> trueConfigsForCurrentTime =
                configs.stream().filter(config -> checkCronTemplate(config.getCron(), currentLocalDateTime))
                        .collect(Collectors.toList());
        if (trueConfigsForCurrentTime.size() > 0) {
            Collections.sort(trueConfigsForCurrentTime);
            trueConfig = trueConfigsForCurrentTime.get(0);
        }
        return trueConfig;
    }

    public static Boolean checkCronTemplate(String cron, LocalDateTime currentLocalDateTime) {
        currentLocalDateTime = currentLocalDateTime.withSecond(0).withNano(0);
        Date oldCurrentDate = Date.from(currentLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());
        currentLocalDateTime = currentLocalDateTime.minusMinutes(1);
        Date offsetDate = Date.from(currentLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date nextDate = new CronSequenceGenerator(cron).next(offsetDate);
        return oldCurrentDate.compareTo(nextDate) == 0;
    }

    private void decrementIndicator(Pet pet, Indicator indicator, int decValue) {
        if (pet == null) return; //todo нужна обработка ошибок или забьем по классике?
        switch (indicator) {
            case FOOD_INDICATOR:
                pet.decrementFoodIndicator(decValue);
            case CLEAN_INDICATOR:
                pet.decrementCleanIndicator(decValue);
            case HEALTH_INDICATOR:
                pet.decrementHealthIndicator(decValue);
            case SLEEP_INDICATOR:
                pet.decrementSleepIndicator(decValue);
        }
    }

    @Override
    public List<UpdateHistory> createHistoriesForScheduler() {
        LocalDateTime currentLocalDateTime = LocalDateTime.now().withSecond(0).withNano(0);
        List<UpdateHistory> result = new ArrayList<>();

        for (Indicator indicator : Indicator.values()) {
            Scheduler config = getSuitableScheduledConfig(indicator, currentLocalDateTime);
            UpdateHistory history = createHistory(indicator, config.getDecrementValue(), true);
            result.add(history);
        }
        return result;
    }

    private UpdateHistory createHistory(Indicator indicator, Integer decrementValue, Boolean isScheduling) {
        UpdateHistory history = new UpdateHistory();
        history.setDecrementValue(decrementValue);
        history.setIndicator(indicator);
        history.setIsScheduling(isScheduling);
        history.setInsertDate(new Date());
        history.setIsScheduling(isScheduling);
        return historyRepository.save(history);
    }

}
