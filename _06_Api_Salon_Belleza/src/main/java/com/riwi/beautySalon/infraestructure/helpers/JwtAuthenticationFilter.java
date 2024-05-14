package com.riwi.beautySalon.infraestructure.helpers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter {
    @Autowired
    private final JwtService jwtService;
    @Autowired
    private final UserDetailsService userDetailsService;

    public void doFilterInternal(HttpServletRequest request,
         HttpServletResponse response, FilterChain filterChain) 
         throws IOException, ServletException {

        /*1. Obtener el token */
        final  String token = getTokenFromRequest(request);


        /** Si el token es nullo entonces seguir con los filtros de spring*/
        if(token == null){
            filterChain.doFilter(request, response);
            return;
        }
    }

    /*Método para obtener el token del request */
    public String getTokenFromRequest(HttpServletRequest request){

        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        //Si el token no está vacío y además inicia con la palabra Bearer entonces
        if (StringUtils.hasLength(authHeader) && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }
}
