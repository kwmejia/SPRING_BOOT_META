package com.riwi.beautySalon.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.beautySalon.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
    public Optional<User> findByUserName(String username);
}
