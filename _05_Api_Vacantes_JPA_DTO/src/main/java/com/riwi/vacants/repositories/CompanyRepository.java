package com.riwi.vacants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.vacants.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

}
