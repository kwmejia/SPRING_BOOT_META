package com.riwi.beautySalon.api.dto.request;

import com.riwi.beautySalon.utils.enums.RoleEmployee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeReq {
    @NotBlank(message = "El nombre es requerido")
    private String firstName;
    @NotBlank(message = "El apellido es requerido")
    private String lastName;
    @Size(
        min = 10, 
        max = 20, 
        message = "El teléfono debe tener entre 10 y 20 caracteres"
    )
    private String phone;
    @Email(message = "El email no es válido")
    @Size(
        min = 5, 
        max = 100,
        message = "El email debe tener entre 5 y 100 caracteres"
    )
    private String email;
    @NotNull(message = "El rol es requerido")
    private RoleEmployee role;

}
