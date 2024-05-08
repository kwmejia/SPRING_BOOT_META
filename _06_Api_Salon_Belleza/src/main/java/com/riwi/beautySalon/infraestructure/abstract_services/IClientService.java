package com.riwi.beautySalon.infraestructure.abstract_services;

import com.riwi.beautySalon.api.dto.request.ClientReq;
import com.riwi.beautySalon.api.dto.response.ClientResp;

public interface IClientService  
    extends CrudService<ClientReq,ClientResp, Long>{
    
    public String FIELD_BY_SORT = "firstName";
}
