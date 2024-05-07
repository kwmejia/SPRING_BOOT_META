package com.riwi.beautySalon.api.dto.response;

import java.util.List;

import com.riwi.beautySalon.domain.entities.Appointment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientResp {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private List<Appointment> appointments;
}
