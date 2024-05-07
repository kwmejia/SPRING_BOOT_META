package com.riwi.beautySalon.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.beautySalon.domain.entities.ServiceEntity;

@Repository
public interface ServiceRepository 
    extends JpaRepository<ServiceEntity,Long> {
    
}
