package com.waracle.code.challenge.cakemanager.service;

import com.waracle.code.challenge.cakemanager.entity.Cake;
import com.waracle.code.challenge.cakemanager.model.CakeModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public interface CakeService {

    public List<CakeModel> getCakes();

    public CakeModel getCake(long cakeId);

    public CakeModel addCake(CakeModel cakemodel);

    public CakeModel updateCake(CakeModel cakeModel, long id);

    public void deleteCake(Long cakeId);
}
