package com.waracle.code.challenge.cakemanager.api;

import com.waracle.code.challenge.cakemanager.model.CakeModel;
import com.waracle.code.challenge.cakemanager.model.ClientInfoCakeModel;
import com.waracle.code.challenge.cakemanager.service.ClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("cake-manager")
public class ClientInfoController {

    @Autowired
    private ClientInfoService clientInfoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/orderById/{id}")
    public List<ClientInfoCakeModel> getCakeByOrderId(@PathVariable Long id) {
        return clientInfoService.getCakeByClientId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/orderByClient/{clientName}")
    public List<CakeModel> getCakeByClientName(@PathVariable String clientName) {
        return clientInfoService.getCakeByClientName(clientName);
    }
}
