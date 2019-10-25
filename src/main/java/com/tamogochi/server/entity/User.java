package com.tamogochi.server.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    private String id;
    private String email;
    private Date createDate;
    private Date lastDate;
    @OneToOne
    @JoinColumn(name = "pet")
    private Pet pet;
}
