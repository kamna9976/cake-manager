package com.waracle.code.challenge.cakemanager.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.context.Lifecycle;

import javax.persistence.*;
import java.io.*;

@Entity
@Data
@Table(name="cakes")
public class Cake extends Object implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;

    @Column(name="name")
    private String name;

    @Column(name="cake_type")
    private String type;

    public Cake() {

    }

    public Cake(long id, String name, String type) {
        Id = id;
        this.name = name;
        this.type = type;
    }

    public Cake(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
