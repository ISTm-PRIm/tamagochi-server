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
}
