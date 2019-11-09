package com.tamogochi.server.entity;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

import static com.tamogochi.server.service.Constant.INDICATOR_MAX_VALUE;
import static com.tamogochi.server.service.Constant.INDICATOR_MIN_VALUE;
import static com.tamogochi.server.service.Constant.MEAL_FOR_FOOD;

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
        if (this.foolIndicator - value >= INDICATOR_MIN_VALUE) {
            this.foolIndicator -= value;
        }
        if (this.foolIndicator <= 20) {
            decrementHealthIndicator(1);
        }
    }

    public void incFoodIndicator() {
        if (this.foolIndicator + MEAL_FOR_FOOD <= INDICATOR_MAX_VALUE) {
            this.foolIndicator += MEAL_FOR_FOOD;
        } else {
            this.foolIndicator = INDICATOR_MAX_VALUE;
        }
    }

    public void decrementHealthIndicator(int value) {
        if (this.healthIndicator - value >= INDICATOR_MIN_VALUE) {
            this.healthIndicator -= value;
        }
    }

    public void incHealthIndicator(int value) {
        if (this.healthIndicator + value <= healthIndicator) {
            this.healthIndicator += value;
        } else {
            this.healthIndicator = INDICATOR_MAX_VALUE;
        }
    }

    public void decrementCleanIndicator(int value) {
        if (this.cleanIndicator - value >= INDICATOR_MIN_VALUE) {
            this.cleanIndicator -= value;
        }
        if (this.cleanIndicator <= 20) {
            decrementHealthIndicator(1);
        }
    }

    public void incCleanIndicator() {
        this.cleanIndicator = INDICATOR_MAX_VALUE;
    }

    public void decrementSleepIndicator(int value) {
        if (this.sleepIndicator - value >= INDICATOR_MIN_VALUE) {
            this.sleepIndicator -= value;
        }
        if (this.sleepIndicator <= 20) {
            decrementHealthIndicator(1);
        }
    }

    public void incSleepIndicator(int value) {
        if (this.sleepIndicator <= 25) {
            this.sleepIndicator += value;
        }
    }
}
