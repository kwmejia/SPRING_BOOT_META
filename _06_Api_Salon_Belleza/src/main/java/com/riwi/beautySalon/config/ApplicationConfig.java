package com.riwi.beautySalon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.riwi.beautySalon.domain.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class ApplicationConfig {
    /*Inyectamos el repositorio del usuario */
    @Autowired
    private final UserRepository userRepository;
    

    /**
     * AuthenticationManager permite el manejo del usuario en toda la app
     * Define un bean de tipo AuthenticationManager
     * Utiliza la configuración de spring security para obtener una configuración ya preparada (la que viene por defecto)
     */
    @Bean
    public AuthenticationManager authenticationManager(
        AuthenticationConfiguration config
    ) throws Exception {

        return config.getAuthenticationManager();
    }
    /**
     * Este método crea y configura un DaoAuthenticationProvider, que es una de las implementaciones mas comunes para proveer datos a nuestra app, de esta forma guardaremos las credenciales del usuario.
     * Guardaremos toda la información y el tipo en cifrado que tiene su contraseña
     */
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setPasswordEncoder(this.passwordEncoder());
        authenticationProvider.setUserDetailsService(this.userDetailsService());

        return authenticationProvider;
    }

    /**
     * Este servicio es utilizado por Spring Security para  cargar detalles del usuario durante la autenticación
     */
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> userRepository.findByUserName(username)
            .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }

    /**
     * Define un bean para PasswordEnconder
     * Este encoder es utilizado para encriptar y desencriptar las contraseñas  en la aplicacion
     * retorna  una instacioa  de BCryptPasswordEncoder , es un método  de cifrado  o hash  fuertemente y ampliamente utilizado
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
