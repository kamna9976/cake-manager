package com.waracle.code.challenge.cakemanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
@Data
@Table(name = "client_info")
public class ClientInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private long clientId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email_address")
    private String emailAddress;

    @OneToMany (targetEntity = Cake.class, cascade = CascadeType.ALL)
    @JoinTable(name = "client_cake",
    joinColumns = @JoinColumn(name="client_id"),inverseJoinColumns =@JoinColumn(name = "id"))
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private List<Cake> cakeList = new ArrayList<>();
}
