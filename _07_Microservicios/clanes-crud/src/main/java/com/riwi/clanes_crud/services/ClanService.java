package com.riwi.clanes_crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.clanes_crud.dto.request.ClanGetReq;
import com.riwi.clanes_crud.dto.request.ClanReq;
import com.riwi.clanes_crud.dto.request.ClanUpdateReq;
import com.riwi.clanes_crud.entities.Clan;
import com.riwi.clanes_crud.repositories.ClanRepository;
import com.riwi.clanes_crud.services.abtract_service.IClanService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ClanService implements IClanService {

    @Autowired
    private final ClanRepository  clanRepository;

    @Override
    public Page<Clan> findAll(ClanGetReq req) {
        if (req.getPage() < 0) req.setPage(0);

        PageRequest pagination = PageRequest.of(req.getPage(), req.getSize());
        log.info("Request: {}", req);
        return this.clanRepository.getAll(
            req.getName(),
            req.getDescription(),
            req.getIsActive(),
            req.getCohortId(),
            pagination
        );
    }

    @Override
    public Clan create(ClanReq req) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Clan update(Long id, ClanUpdateReq req) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Clan disable(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'disable'");
    }
    
}
