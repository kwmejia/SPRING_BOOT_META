package com.riwi.beautySalon.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "appointment")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    @Column(nullable = false)
    private LocalDateTime dateTime;
    @Column(nullable = false)
    private Integer duration;
    @Lob // -> Mapear a tipo TEXT en la DB
    private String comments;

    /*RELACIONES */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "client_id", 
        referencedColumnName = "id"
    )
    private ClientEntity client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "service_id",
        referencedColumnName = "id"
    )
    private ServiceEntity service;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "employee_id",
        referencedColumnName = "id"
    )
    private Employee employee;
}
