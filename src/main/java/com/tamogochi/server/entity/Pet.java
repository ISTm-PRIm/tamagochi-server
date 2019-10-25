package com.tamogochi.server.entity;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

import static com.tamogochi.server.service.Constant.INDICATOR_MIN_VALUE;

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
    }

    public void decrementHealthIndicator(int value) {
        if (this.healthIndicator - value >= INDICATOR_MIN_VALUE) {
            this.healthIndicator -= value;
        }
    }

    public void decrementCleanIndicator(int value) {
        if (this.cleanIndicator - value >= INDICATOR_MIN_VALUE) {
            this.cleanIndicator -= value;
        }
    }

    public void decrementSleepIndicator(int value) {
        if (this.sleepIndicator - value >= INDICATOR_MIN_VALUE) {
            this.sleepIndicator -= value;
        }
    }
}
