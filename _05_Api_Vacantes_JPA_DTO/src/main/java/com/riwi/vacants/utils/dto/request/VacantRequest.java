package com.riwi.vacants.utils.dto.request;

import com.riwi.vacants.utils.enums.StatusVacant;

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
public class VacantRequest {
    @Size(min = 0, max = 255)
    @NotBlank(message = "El titulo es requerido")
    private String title;
    @NotBlank(message = "La descripcion es requerida")
    private String description;
    private StatusVacant status;
    @Size(min = 0, max = 32)
    @NotBlank(message = "El id de la compañia es requerido")
    private String companyId;
}
