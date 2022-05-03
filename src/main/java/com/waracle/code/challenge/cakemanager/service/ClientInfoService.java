package com.waracle.code.challenge.cakemanager.service;

import com.waracle.code.challenge.cakemanager.model.CakeModel;
import com.waracle.code.challenge.cakemanager.model.ClientInfoCakeModel;

import java.util.*;

public interface ClientInfoService {

    public List<ClientInfoCakeModel> getCakeByClientId(long id);

    public List<CakeModel> getCakeByClientName(String clientName);
}
