package com.riwi.clanes_crud.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.riwi.clanes_crud.entities.Cohort;
import com.riwi.clanes_crud.repositories.CohortRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class DatabaseSeed implements CommandLineRunner {
    @Autowired
    private final CohortRepository cohortRepository;

    @Override
    public void run(String... args) throws Exception {
       log.info("Seeding database Cohort Executed"); 

       if (this.cohortRepository.count() > 0) return;
       
       Cohort cohort1 = Cohort.builder().name("Cohorte 1").build();
       Cohort cohort2 = Cohort.builder().name("Cohorte 2").build();
       Cohort cohort3 = Cohort.builder().name("Cohorte 3").build();

        cohortRepository.save(cohort1);
        cohortRepository.save(cohort2);
        cohortRepository.save(cohort3);
    }
    
}
