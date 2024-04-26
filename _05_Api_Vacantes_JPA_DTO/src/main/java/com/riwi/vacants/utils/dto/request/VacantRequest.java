package com.riwi.vacants.utils.dto.request;

import com.riwi.vacants.utils.enums.StatusVacant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacantRequest {
    private String title;
    private String description;
    private StatusVacant status;
    private String companyId;
}
