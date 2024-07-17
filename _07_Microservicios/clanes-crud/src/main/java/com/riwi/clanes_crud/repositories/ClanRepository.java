package com.riwi.clanes_crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.clanes_crud.entities.Clan;

@Repository
public interface ClanRepository extends JpaRepository<Clan, Long> {
    
}
