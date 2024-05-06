package com.riwi.beautySalon.domain.entities;

import com.riwi.beautySalon.utils.enums.RoleEmployee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity( name = "employee")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String firtsName;
    @Column(length = 100, nullable = false)
    private String lastName;
    @Column(length = 100)
    private String email;
    @Column(length = 20)
    private String phone;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEmployee role;
}
