package com.riwi.beautySalon.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.beautySalon.domain.entities.Employee;

@Repository
public interface EmployeeRepository 
    extends JpaRepository<Employee,Long>{
}
