package com.riwi.primeraweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.repository.CoderRepository;

/*
 * Indica que esta clase será un servicio
 */
@Service
public class CoderService {
    /*
     * Autowired le indica a spring Boot que esto es una inyección de dependencias
     */
    @Autowired
    private CoderRepository objCoderRepository;

    /**
     * Servicio para listar todos los coders
     */
    public List<Coder> findAll() {
        return this.objCoderRepository.findAll();
    }
}
