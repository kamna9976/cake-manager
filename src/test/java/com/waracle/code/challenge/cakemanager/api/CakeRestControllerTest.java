package com.waracle.code.challenge.cakemanager.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.code.challenge.cakemanager.entity.Cake;
import com.waracle.code.challenge.cakemanager.errorhandler.CakeNotFoundException;
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
import org.testng.Assert;

import java.util.*;

@WebMvcTest(CakeServiceController.class)
class CakeRestControllerTest {

    private static final Long LONG_ID_1 = 1L;

    private static final Long LONG_ID_2 = 2L;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CakeServiceImpl cakeService;

    @Test
    void shouldGetAllCakesTest() throws Exception {
        List<CakeModel> cakeModelList = new ArrayList<>();
        cakeModelList.add(new CakeModel(LONG_ID_1, "pinappale cake", "Vegan"));
        cakeModelList.add(new CakeModel(LONG_ID_2, "chocolate cake", "Vegan"));
        Mockito.when(cakeService.getCakes()).thenReturn(cakeModelList);

        mockMvc.perform(MockMvcRequestBuilders.get("/cake-manager/").contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath(("$"), Matchers.hasSize(2)));
    }

    @Test
    void shouldGetACakeByIDTest() throws Exception {
        Cake cake = new Cake(LONG_ID_1, "pinappale cake", "Vegan");
        CakeModel cakeModel = new CakeModel(LONG_ID_1, "pinappale cake", "Vegan");

        Mockito.when(cakeService.getCake(LONG_ID_1)).thenReturn(cakeModel);
        String expectedJson = "{\"id\":1,\"cakeName\":\"pinappale cake\",\"cakeType\":\"Vegan\"}";

        mockMvc.perform(MockMvcRequestBuilders.get("/cake-manager/cakes/1").contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string(expectedJson));
    }

    @Test
    void shouldThrowExceptionIfCakeNotFound() throws Exception {
        Mockito.when(cakeService.getCake(LONG_ID_1)).thenThrow(new CakeNotFoundException(LONG_ID_1));
        mockMvc.perform(MockMvcRequestBuilders.get("/cake-manager/cakes/1").contentType(MediaType.APPLICATION_JSON))
               .andExpect(result -> Assert.assertTrue(result.getResolvedException() instanceof CakeNotFoundException))
               .andExpect(result -> Assert.assertEquals("Cake id not found : " + LONG_ID_1,
                                                        result.getResolvedException().getMessage()));
    }

    @Test
    void shouldUpdateACakeByID() throws Exception {
        CakeModel cakeModel = new CakeModel(LONG_ID_1, "pinappale cake", "Eggs");
        Mockito.when(cakeService.updateCake(cakeModel, LONG_ID_1)).thenReturn(cakeModel);
        String jsonRequestBody = mapToJson(cakeModel);
        mockMvc.perform(MockMvcRequestBuilders.put("/cake-manager/cakes/1").contentType(MediaType.APPLICATION_JSON)
                                              .content(jsonRequestBody))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldCakeNotFoundWhenUpdatedCakeNotFound() throws Exception {
        CakeModel cakeModel = new CakeModel(LONG_ID_1, "pinappale cake", "Eggs");
        Mockito.when(cakeService.updateCake(cakeModel, LONG_ID_1)).thenThrow(new CakeNotFoundException(LONG_ID_1));
        String jsonRequestBody = mapToJson(cakeModel);
        mockMvc.perform(MockMvcRequestBuilders.put("/cake-manager/cakes/1").contentType(MediaType.APPLICATION_JSON)
                                              .content(jsonRequestBody))
               .andExpect(result -> Assert.assertTrue(result.getResolvedException() instanceof CakeNotFoundException))
               .andExpect(result -> Assert.assertEquals("Cake id not found : " + LONG_ID_1,
                                                        result.getResolvedException().getMessage()));
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}
