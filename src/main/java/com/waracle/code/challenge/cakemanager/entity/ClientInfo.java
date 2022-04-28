package com.waracle.code.challenge.cakemanager.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "client_info")
public class ClientInfo {

    @Id
    @GeneratedValue
    private long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email_address")
    private String emailAddress;
}
