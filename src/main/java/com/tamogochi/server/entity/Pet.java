package com.tamogochi.server.entity;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

import static com.tamogochi.server.service.Constant.*;

@Entity
@Table(name = "pet")
@Data
public class Pet {
    @Id
    private String id;
    private String name;
    private Boolean isAlive;
    private Date createDate;
    private int foolIndicator;
    private int healthIndicator;
    private int cleanIndicator;
    private int sleepIndicator;

    public void decrementFoodIndicator(int value) {
        boolean result = this.foolIndicator - value >= INDICATOR_MIN_VALUE;
        this.foolIndicator = result ? this.foolIndicator - value : INDICATOR_MIN_VALUE;
        if (this.foolIndicator <= 20) {
            decrementHealthIndicator(SIDE_EFFECT_FOR_HEALTH);
        }
    }

    public void decrementCleanIndicator(int value) {
        boolean result = this.cleanIndicator - value >= INDICATOR_MIN_VALUE;
        this.cleanIndicator = result ? this.cleanIndicator - value : INDICATOR_MIN_VALUE;

        if (this.cleanIndicator <= 20) {
            decrementHealthIndicator(SIDE_EFFECT_FOR_HEALTH);
        }
    }

    public void decrementSleepIndicator(int value) {
        boolean result = this.sleepIndicator - value >= INDICATOR_MIN_VALUE;
        this.sleepIndicator = result ? this.sleepIndicator - value : INDICATOR_MIN_VALUE;

        if (this.sleepIndicator <= 20) {
            decrementHealthIndicator(SIDE_EFFECT_FOR_HEALTH);
        }
    }

    public void decrementHealthIndicator(int value) {
        boolean result = this.healthIndicator - value >= INDICATOR_MIN_VALUE;
        this.healthIndicator = result ? this.healthIndicator - value : INDICATOR_MIN_VALUE;

        if (this.healthIndicator == INDICATOR_MIN_VALUE) {
            this.isAlive = false; // питомец умер
        }
    }

    public void incFoodIndicator() {
        boolean result = this.foolIndicator + MEAL_FOR_FOOD <= INDICATOR_MAX_VALUE;
        this.foolIndicator = result ? this.foolIndicator += MEAL_FOR_FOOD : INDICATOR_MAX_VALUE;
    }

    public void incHealthIndicator() {
        boolean result = this.healthIndicator + DRUGS_FOR_SOUL <= INDICATOR_MAX_VALUE;
        this.healthIndicator = result ? this.healthIndicator + DRUGS_FOR_SOUL : INDICATOR_MAX_VALUE;
    }

    public void incSleepIndicator() {
        boolean result = this.sleepIndicator + GOOD_DREAMS <= INDICATOR_MAX_VALUE;
        this.sleepIndicator = result ? this.sleepIndicator + GOOD_DREAMS : INDICATOR_MAX_VALUE;
    }

    // вероятность заболеть 10%
    public Boolean isSick() {
        return Math.random() < 0.1;
    }

    public void incCleanIndicator() {
        this.cleanIndicator = INDICATOR_MAX_VALUE;
    }

}
