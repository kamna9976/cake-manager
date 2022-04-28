package com.waracle.code.challenge.cakemanager.api;

import com.waracle.code.challenge.cakemanager.entity.Cake;
import com.waracle.code.challenge.cakemanager.model.CakeModel;
import com.waracle.code.challenge.cakemanager.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("cake-manager")
public class CakeServiceController {

    @Autowired
    private CakeService cakeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<CakeModel> getCakes() {
        return this.cakeService.getCakes();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/cakes/{id}")
    public CakeModel updateCake(final @RequestBody CakeModel cakeModel, @PathVariable Long id) {
        return cakeService.updateCake(cakeModel, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cakes")
    public CakeModel newCake(@RequestBody CakeModel newCake) {
        return cakeService.addCake(newCake);
    }
}
