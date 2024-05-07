package com.riwi.beautySalon.api.dto.response;

import com.riwi.beautySalon.utils.enums.RoleEmployee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResp {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private RoleEmployee role;
}
