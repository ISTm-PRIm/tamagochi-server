package com.tamogochi.server.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "UPDATE_HISTORY")
public class UpdateHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Indicator indicator;
    private Boolean isScheduling;
    private int decrementValue;
    private Date insertDate;
}
