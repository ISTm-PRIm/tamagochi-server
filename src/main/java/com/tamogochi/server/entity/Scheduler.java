package com.tamogochi.server.entity;

import io.swagger.models.auth.In;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "scheduler")
public class Scheduler implements Comparable<Scheduler> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cron;
    private Indicator indicator;
    private int decrementValue;
    private Double priority;

    @Override
    public int compareTo(Scheduler config) {
        return this.priority.compareTo(config.priority);
    }
}
