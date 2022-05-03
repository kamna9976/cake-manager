package com.waracle.code.challenge.cakemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.*;

@Data
public class ClientInfoCakeModel {
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

    public ClientInfoCakeModel () {

    }

    public ClientInfoCakeModel(long id, String clientName, String clientAddress, String clientEmail,
                               List<CakeModel> cakeModelList) {
        this.id = id;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientEmail = clientEmail;
        this.cakeModelList = cakeModelList;
    }
}
