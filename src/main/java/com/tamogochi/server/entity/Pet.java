package com.tamogochi.server.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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
        this.foolIndicator -= value;
    }

    public void decrementHealthIndicator(int value) {
        this.healthIndicator -= value;
    }

    public void decrementCleanIndicator(int value) {
        this.cleanIndicator -= value;
    }

    public void decrementSleepIndicator(int value) {
        this.sleepIndicator -= value;
    }
}
