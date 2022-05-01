package com.waracle.code.challenge.cakemanager.serviceimpl;

import com.waracle.code.challenge.cakemanager.entity.Cake;
import com.waracle.code.challenge.cakemanager.errorhandler.CakeNotFoundException;
import com.waracle.code.challenge.cakemanager.model.CakeModel;
import com.waracle.code.challenge.cakemanager.repository.CakeReposiroty;
import com.waracle.code.challenge.cakemanager.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Transactional
@Service
public class CakeServiceImpl implements CakeService{

    @Autowired
    private CakeReposiroty cakeReposiroty;

    @Override
    public List<CakeModel> getCakes() {
        List<CakeModel> cakeModelList = new ArrayList<>();
        cakeReposiroty.findAll().stream().forEach(cake -> {
            cakeModelList.add(new CakeModel(cake.getId(), cake.getName(), cake.getType()));
        });
        return cakeModelList;
    }

    public CakeModel getCake(Long cakeId) {
        Cake cake =  cakeReposiroty.findById(cakeId)
            .orElseThrow(() -> new CakeNotFoundException(cakeId));
        return new CakeModel(cake.getId(), cake.getName(), cake.getType());

    }

    @Override
    @Transactional
    public CakeModel addCake(CakeModel cakemodel) {
        Cake cake = cakeReposiroty.save(new Cake(cakemodel.getCakeName(), cakemodel.getCakeType()));
        return new CakeModel(cake.getId(), cake.getName(), cake.getType());
    }

    @Override
    public CakeModel updateCake(CakeModel cakeModel, Long id) {
        Cake cake = cakeReposiroty.findById(id).map(oldCake -> {
            oldCake.setId(cakeModel.getId());
            oldCake.setName(cakeModel.getCakeName());
            oldCake.setType(cakeModel.getCakeType());
            return cakeReposiroty.save(oldCake);
        }).orElseThrow(() -> new CakeNotFoundException(id));
        return new CakeModel(cake.getId(), cake.getName(), cake.getType());
    }

    @Override
    public void deleteCake(Long cakeId) {
        cakeReposiroty.deleteById(cakeId);
    }
}
