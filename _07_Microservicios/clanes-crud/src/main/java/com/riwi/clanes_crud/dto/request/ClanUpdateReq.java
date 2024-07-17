package com.riwi.clanes_crud.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClanUpdateReq extends ClanReq {
    private Boolean isActive;
}
