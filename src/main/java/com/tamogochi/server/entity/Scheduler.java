package com.tamogochi.server.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "scheduler")
public class Scheduler implements Comparable<Scheduler> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cron;
    @Enumerated(EnumType.STRING)
    private Indicator indicator;
    private int decrementValue;
    private Double priority;

    @Override
    public int compareTo(Scheduler config) {
        return this.priority.compareTo(config.priority);
    }
}
