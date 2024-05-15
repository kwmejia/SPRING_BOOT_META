package com.riwi.beautySalon.infraestructure.abstract_services;

import com.riwi.beautySalon.api.dto.request.ClientRegisterReq;
import com.riwi.beautySalon.api.dto.request.EmployeeRegisterReq;
import com.riwi.beautySalon.api.dto.request.LoginReq;
import com.riwi.beautySalon.api.dto.request.RegisterReq;
import com.riwi.beautySalon.api.dto.response.AuthResp;

public interface IAuthService {
    
    public AuthResp login(LoginReq request);
    
    public AuthResp register(RegisterReq request);

    public AuthResp registerClient(ClientRegisterReq request);

    public AuthResp registerEmployee(EmployeeRegisterReq request);
}
