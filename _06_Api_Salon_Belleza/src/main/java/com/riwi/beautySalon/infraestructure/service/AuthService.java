package com.riwi.beautySalon.infraestructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.riwi.beautySalon.api.dto.request.LoginReq;
import com.riwi.beautySalon.api.dto.request.RegisterReq;
import com.riwi.beautySalon.api.dto.response.AuthResp;
import com.riwi.beautySalon.domain.entities.User;
import com.riwi.beautySalon.domain.repositories.UserRepository;
import com.riwi.beautySalon.infraestructure.abstract_services.IAuthService;
import com.riwi.beautySalon.infraestructure.helpers.JwtService;
import com.riwi.beautySalon.utils.enums.Role;
import com.riwi.beautySalon.utils.exception.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final PasswordEncoder passwordEncoder;
        
    @Autowired
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResp login(LoginReq request) {
        
        try {
            //Autenticar en la app
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request. getPassword()));
        } catch (Exception e) {
            throw new BadRequestException("Credenciales invalidas");
        }

        //SI el usuario se autenticó correctamente
        User user = this.findByUserName(request.getUserName());

        if (user == null) {
            throw new BadRequestException("El usuario no está registrado");
        }

        return AuthResp.builder()
                .message("Autenticado correctamente")
                .token(this.jwtService.getToken(user))
                .build();
        

    }

    @Override
    public AuthResp register(RegisterReq request) {
       /*1. Validar que userName no exista */
       User exist = this.findByUserName(request.getUserName());

       if (exist != null) {
            throw new BadRequestException("Este nombre de usuario ya está registrado.");
       }

       /*2. Construimos el nuevo usuario */

       User user = User.builder()
                    .userName(request.getUserName())
                    //Guardar la contraseña codificada
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.CLIENT)
                    .build();
        
        /*3. Guardar el nuevo usuario en la db*/
       this.userRepository.save(user);

       return AuthResp.builder()
                .message("Se registró exitosamente")
                .token(this.jwtService.getToken(user))
                .build();

    }
    
    private User findByUserName(String userName){
        return this.userRepository.findByUserName(userName)
                    .orElse(null);
    }
}
