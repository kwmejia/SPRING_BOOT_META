package com.riwi.beautySalon.domain.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.riwi.beautySalon.domain.entities.ServiceEntity;

@Repository
public interface ServiceRepository 
    extends JpaRepository<ServiceEntity,Long> {
        @Query("select s from service s where s.price between :min and :max")
        public List<ServiceEntity> selectBetweenPrice(BigDecimal min, BigDecimal max);

        // @Query( value = "select * from service where service.name like :search", nativeQuery = true)
        @Query("select s from service s where s.name like :search")
        public List<ServiceEntity> findByNameContaining(String search);

}
