package com.waracle.code.challenge.cakemanager.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.code.challenge.cakemanager.entity.Cake;
import com.waracle.code.challenge.cakemanager.model.CakeModel;
import com.waracle.code.challenge.cakemanager.repository.CakeReposiroty;
import com.waracle.code.challenge.cakemanager.serviceimpl.CakeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testng.Assert;

import java.util.*;

@ExtendWith(SpringExtension.class)
public class CakeServiceTest {

    static final ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    CakeServiceImpl cakeService;

    @Mock
    CakeReposiroty cakeReposiroty;

    @Test
    public void shouldGetAllCakeListTest() throws Exception {
        List<Cake> cakeList = new ArrayList<>();
        cakeList.add(new Cake("pinappale cake", "Vegan"));
        cakeList.add(new Cake("chocolate cake", "Vegan"));
        Mockito.when(cakeReposiroty.findAll()).thenReturn(cakeList);
        List<CakeModel> result = cakeService.getCakes();
        Assert.assertEquals(result.size(), 2);
    }



}
