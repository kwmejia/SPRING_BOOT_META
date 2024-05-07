package com.riwi.beautySalon.api.dto.response;

import java.time.LocalDateTime;

import com.riwi.beautySalon.domain.entities.ClientEntity;
import com.riwi.beautySalon.domain.entities.Employee;
import com.riwi.beautySalon.domain.entities.ServiceEntity;

public class AppointmentResp {
    private Long id;    
    private LocalDateTime dateTime;
    private Integer duration;
    private String comments;
    private ClientEntity client;
    private ServiceResp service;
    private EmployeeResp employee;
}
