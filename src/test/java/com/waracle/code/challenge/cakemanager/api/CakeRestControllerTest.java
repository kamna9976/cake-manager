package com.waracle.code.challenge.cakemanager.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.code.challenge.cakemanager.model.CakeModel;
import com.waracle.code.challenge.cakemanager.serviceimpl.CakeServiceImpl;
import org.hamcrest.Matchers;
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

@WebMvcTest(CakeServiceController.class)
public class CakeRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CakeServiceImpl cakeService;

    @Test
    public void getAllCakesTest() throws Exception {
        List<CakeModel> cakeList = new ArrayList<>();
        cakeList.add(new CakeModel(1,"pinappale cake", "Vegan"));
        cakeList.add(new CakeModel(2, "chocolate cake", "Vegan"));
        Mockito.when(cakeService.getCakes()).thenReturn(cakeList);

        mockMvc.perform(MockMvcRequestBuilders.get("/cake-manager/")
                            .contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath(("$"), Matchers.hasSize(2)));

    }

}
