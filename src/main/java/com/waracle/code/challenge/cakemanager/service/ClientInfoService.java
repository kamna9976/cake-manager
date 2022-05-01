package com.waracle.code.challenge.cakemanager.service;

import com.waracle.code.challenge.cakemanager.model.CakeModel;
import com.waracle.code.challenge.cakemanager.model.OrderCakeModel;

import java.util.*;

public interface ClientInfoService {

    public OrderCakeModel getCakeByOrderId(long id);

    public List<CakeModel> getCakeByClientName(String clientName);
}
