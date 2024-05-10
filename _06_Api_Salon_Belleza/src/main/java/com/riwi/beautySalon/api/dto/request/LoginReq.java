package com.riwi.beautySalon.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginReq {
    @NotBlank(message = "El userName es requerido")
    @Size(min = 3, max = 150, message = "El nombre de usuario debe tener entre 3 y 150 caracteres")
    private String userName;
    @NotBlank(message = "La contraseña es requerida")
    @Size(min = 6, max = 150, message = "La contraseña debe tener entre 6 y 150 caracteres")
    // @Pattern(regexp = "expresión regular")
    private String password;
}
