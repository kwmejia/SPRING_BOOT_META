package com.riwi.clanes_crud.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.clanes_crud.dto.request.ClanGetReq;
import com.riwi.clanes_crud.dto.request.ClanReq;
import com.riwi.clanes_crud.dto.request.ClanUpdateReq;
import com.riwi.clanes_crud.entities.Clan;
import com.riwi.clanes_crud.entities.Cohort;
import com.riwi.clanes_crud.repositories.ClanRepository;
import com.riwi.clanes_crud.repositories.CohortRepository;
import com.riwi.clanes_crud.services.abtract_service.IClanService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ClanService implements IClanService {

    @Autowired
    private final ClanRepository  clanRepository;
    @Autowired
    private final CohortRepository cohortRepository;

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
       Cohort cohort = this.cohortRepository.findById(req.getCohortId())
            .orElseThrow(() -> new RuntimeException("Cohort not found"));
        
        Clan clan = Clan.builder()
            .name(req.getName())
            .description(req.getDescription())
            .cohort(cohort)
            .build();

        return this.clanRepository.save(clan);
    }

    @Override
    public Clan update(Long id, ClanUpdateReq req) {
       Clan clan  = this.clanRepository.findById(id)
        .orElseThrow( () -> new RuntimeException("Clan not found"));

        if(req.getCohortId() != clan.getCohort().getId()){
            Cohort cohort = this.cohortRepository.findById(req.getCohortId())
                .orElseThrow(() -> new RuntimeException("Cohort not found"));

            clan.setCohort(cohort);
        }

        clan.setName(req.getName());
        clan.setDescription(req.getDescription());
        clan.setUpdatedAt(LocalDateTime.now());

        return this.clanRepository.save(clan);
    }

    @Override
    public Clan disable(Long id) {
        Clan clan  = this.clanRepository.findById(id)
        .orElseThrow( () -> new RuntimeException("Clan not found"));

        clan.setIsActive(false);
        clan.setUpdatedAt(LocalDateTime.now());

        return this.clanRepository.save(clan);
    }
    
}
