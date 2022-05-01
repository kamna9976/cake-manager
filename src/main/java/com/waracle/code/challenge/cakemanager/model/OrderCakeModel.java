package com.waracle.code.challenge.cakemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.*;

@Data
public class OrderCakeModel {
    @JsonIgnore
    private long id;

    @JsonProperty
    private String clientName;

    @JsonProperty
    private String clientAddress;

    @JsonProperty
    private String clientEmail;

    @JsonProperty
    private List<CakeModel> cakeModelList;

}
