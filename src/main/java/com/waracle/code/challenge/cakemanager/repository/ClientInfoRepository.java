package com.waracle.code.challenge.cakemanager.repository;

import com.waracle.code.challenge.cakemanager.entity.ClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface ClientInfoRepository extends JpaRepository <ClientInfo, Long> {
    public List<ClientInfo> getClientInfoByClientId(Long id);
    public List<ClientInfo> getClientInfosByName(String name);
}
