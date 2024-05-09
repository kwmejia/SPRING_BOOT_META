package com.riwi.beautySalon.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {
    

    @PostMapping(path = "/auth/login")
    public String login(){
        return "HACIENDO EL LOGIN";
    }

    @PostMapping(path = "/auth/register")
    public String register(){
        return "HACIENDO EL LOGIN";
    }
}
