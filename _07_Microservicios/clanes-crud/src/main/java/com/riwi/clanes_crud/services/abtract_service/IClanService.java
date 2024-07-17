package com.riwi.clanes_crud.services.abtract_service;

import org.springframework.data.domain.Page;

import com.riwi.clanes_crud.dto.request.ClanGetReq;
import com.riwi.clanes_crud.dto.request.ClanReq;
import com.riwi.clanes_crud.dto.request.ClanUpdateReq;
import com.riwi.clanes_crud.entities.Clan;

public interface IClanService {
    public Page<Clan> findAll(ClanGetReq req);
    public Clan create(ClanReq req);
    public Clan update(Long id, ClanUpdateReq req);
    public Clan disable(Long id);
}
