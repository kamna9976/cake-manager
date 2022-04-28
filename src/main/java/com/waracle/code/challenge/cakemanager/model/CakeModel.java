package com.waracle.code.challenge.cakemanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CakeModel {

    @JsonProperty
    private long id;

    @JsonProperty
    private String cakeName;

    @JsonProperty
    private String cakeType;


    public CakeModel(long id, String cakeName, String cakeType) {
        this.id = id;
        this.cakeName = cakeName;
        this.cakeType = cakeType;
    }
}
