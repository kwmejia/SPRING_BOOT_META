package com.riwi.beautySalon.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.beautySalon.api.dto.request.RegisterReq;
import com.riwi.beautySalon.api.dto.response.AuthResp;
import com.riwi.beautySalon.infraestructure.abstract_services.IAuthService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {
    
    @Autowired
    private final IAuthService authService;

    @PostMapping(path = "/auth/login")
    public String login(){
        return "HACIENDO EL LOGIN";
    }

    @PostMapping(path = "/auth/register")
    public ResponseEntity<AuthResp> register(
        @Validated @RequestBody RegisterReq request
    ){
        return ResponseEntity.ok(this.authService.register(request));
    }
}
