package com.waracle.code.challenge.cakemanager.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "client_cake")
public class ClientCake {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "client_id")
    private long clientId;

    @Column(name = "cake_id")
    private long CakeId;
}
