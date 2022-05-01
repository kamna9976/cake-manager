package com.waracle.code.challenge.cakemanager.serviceimpl;

import com.waracle.code.challenge.cakemanager.entity.Cake;
import com.waracle.code.challenge.cakemanager.entity.ClientInfo;
import com.waracle.code.challenge.cakemanager.model.CakeModel;
import com.waracle.code.challenge.cakemanager.model.OrderCakeModel;
import com.waracle.code.challenge.cakemanager.repository.ClientInfoRepository;
import com.waracle.code.challenge.cakemanager.service.ClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class ClientInfoServiceImpl implements ClientInfoService {

    @Autowired
    ClientInfoRepository orderCakeRepository;

    @Override
    public OrderCakeModel getCakeByOrderId(long orderId) {
        ClientInfo clientInfoList = orderCakeRepository.getClientInfoByClientId(orderId).get(0);
        List<Cake> cakes = clientInfoList.getCakeList();
        OrderCakeModel orderCakeModel = new OrderCakeModel();
        orderCakeModel.setClientName(clientInfoList.getName());
        orderCakeModel.setClientAddress(clientInfoList.getAddress());
        orderCakeModel.setClientEmail(clientInfoList.getEmailAddress());
        List<CakeModel> cakeModelList = new ArrayList<>();
        cakes.stream().forEach(cake -> {
            cakeModelList.add(new CakeModel(cake.getId(), cake.getName(), cake.getType()));
        });
        orderCakeModel.setCakeModelList(cakeModelList);
        return orderCakeModel;
    }

    @Override
    public List<CakeModel> getCakeByClientName(String clientName) {
        List<ClientInfo> orderCakeList = orderCakeRepository.getClientInfosByName(clientName);
        List<CakeModel> cakeModelList = new ArrayList<>();
        orderCakeList.stream().forEach(orderCake -> {
            orderCake.getCakeList().stream().forEach(cake -> {
                cakeModelList.add(new CakeModel(cake.getId(), cake.getName(), cake.getType()));
            });
        });
        return cakeModelList;
    }
}
