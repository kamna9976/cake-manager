package com.waracle.code.challenge.cakemanager.repository;

import com.waracle.code.challenge.cakemanager.entity.Cake;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.transaction.Transactional;
import java.util.*;

@DataJpaTest
class CakeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CakeReposiroty cakeReposiroty;

    @Test
    @Transactional
    void ShouldFindNoCakeWhenNoCakeIsPresent() {
        cakeReposiroty.deleteAll();
        List<Cake> cakeList = cakeReposiroty.findAll();
        Assertions.assertTrue(CollectionUtils.isEmpty(cakeList));
    }

    @Test
    void ShouldGetAllTheCakesWhenFindAll() {
        List<Cake> cakeList = cakeReposiroty.findAll();
        Assertions.assertTrue(cakeList.size() == 3);
    }

    @Test
    void shouldUpdateOneCakeByIdIfCakeExists() {

    }
}
