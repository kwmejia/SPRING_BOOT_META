package com.riwi.clanes_crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.clanes_crud.entities.Cohort;

@Repository
public interface CohortRepository extends JpaRepository<Cohort, Long> {
    
}
