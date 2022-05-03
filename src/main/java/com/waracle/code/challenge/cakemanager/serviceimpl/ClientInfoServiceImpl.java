package com.waracle.code.challenge.cakemanager.serviceimpl;

import com.waracle.code.challenge.cakemanager.entity.Cake;
import com.waracle.code.challenge.cakemanager.entity.ClientInfo;
import com.waracle.code.challenge.cakemanager.model.CakeModel;
import com.waracle.code.challenge.cakemanager.model.ClientInfoCakeModel;
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
    ClientInfoRepository clientInfoRepository;

    @Override
    public List<ClientInfoCakeModel> getCakeByClientId(long clientId) {
        List<ClientInfo> orderCakeList = clientInfoRepository.getClientInfoByClientId(clientId);
        List<ClientInfoCakeModel> clientInfoCakeModelList = new ArrayList<>();
        orderCakeList.stream().forEach(orderCake -> {
            ClientInfoCakeModel clientInfoCakeModel = new ClientInfoCakeModel();
            List<CakeModel> cakeModelList = new ArrayList<>();

            clientInfoCakeModel.setId(orderCake.getClientId());
            clientInfoCakeModel.setClientName(orderCake.getName());
            clientInfoCakeModel.setClientAddress(orderCake.getAddress());
            clientInfoCakeModel.setClientEmail(orderCake.getEmailAddress());

            orderCake.getCakeList().stream().forEach(cake -> {
                cakeModelList.add(new CakeModel(cake.getId(), cake.getName(), cake.getType()));
            });
            clientInfoCakeModel.setCakeModelList(cakeModelList);
            clientInfoCakeModelList.add(clientInfoCakeModel);
        });

        /*ClientInfo clientInfoList = clientInfoRepository.getClientInfoByClientId(clientId).get(0);
        List<Cake> cakes = clientInfoList.getCakeList();
        ClientInfoCakeModel orderCakeModel = new ClientInfoCakeModel();
        orderCakeModel.setClientName(clientInfoList.getName());
        orderCakeModel.setClientAddress(clientInfoList.getAddress());
        orderCakeModel.setClientEmail(clientInfoList.getEmailAddress());
        List<CakeModel> cakeModelList = new ArrayList<>();
        cakes.stream().forEach(cake -> {
            cakeModelList.add(new CakeModel(cake.getId(), cake.getName(), cake.getType()));
        });
        orderCakeModel.setCakeModelList(cakeModelList);*/
        return clientInfoCakeModelList;
    }

    @Override
    public List<CakeModel> getCakeByClientName(String clientName) {
        List<ClientInfo> orderCakeList = clientInfoRepository.getClientInfosByName(clientName);
        List<CakeModel> cakeModelList = new ArrayList<>();
        orderCakeList.stream().forEach(orderCake -> {
            orderCake.getCakeList().stream().forEach(cake -> {
                cakeModelList.add(new CakeModel(cake.getId(), cake.getName(), cake.getType()));
            });
        });
        return cakeModelList;
    }
}
