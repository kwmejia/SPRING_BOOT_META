package com.riwi.beautySalon.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.beautySalon.domain.entities.ClientEntity;

@Repository
public interface ClientRepository 
    extends JpaRepository<ClientEntity, Long> {
    
}
