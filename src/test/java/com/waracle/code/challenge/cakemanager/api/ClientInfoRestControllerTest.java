package com.waracle.code.challenge.cakemanager.api;

import com.waracle.code.challenge.cakemanager.model.CakeModel;
import com.waracle.code.challenge.cakemanager.model.ClientInfoCakeModel;
import com.waracle.code.challenge.cakemanager.serviceimpl.ClientInfoServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

@WebMvcTest(ClientInfoController.class)
class ClientInfoRestControllerTest {

    private static final Long LONG_ID_1 = 1L;

    private static final Long LONG_ID_2 = 2L;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ClientInfoServiceImpl clientInfoService;

    @BeforeEach
    void setup() {
        List<ClientInfoCakeModel> clientInfoCakeModelList = new ArrayList<>();
        List<CakeModel> cakeModelList = new ArrayList<>();
        cakeModelList.add(new CakeModel(LONG_ID_1, "pinappale cake", "Vegan"));
        cakeModelList.add(new CakeModel(LONG_ID_2, "chocolate cake", "Vegan"));
        ClientInfoCakeModel clientInfoCakeModel =
            new ClientInfoCakeModel(5, "Waracle", "Scotland", "waracle.email.com", cakeModelList);
        clientInfoCakeModelList.add(clientInfoCakeModel);

        Mockito.when(clientInfoService.getCakeByClientId(1)).thenReturn(clientInfoCakeModelList);
        Mockito.when(clientInfoService.getCakeByClientName("Waracle")).thenReturn(cakeModelList);
    }

    @Test
    void shouldGetAllCakesByClientId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cake-manager/orderById/1").contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath(("$"), Matchers.hasSize(1)));
    }

    @Test
    void shouldGetAllCakesByClientName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cake-manager/orderByClient/Waracle").contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath(("$"), Matchers.hasSize(2)));
    }

}
