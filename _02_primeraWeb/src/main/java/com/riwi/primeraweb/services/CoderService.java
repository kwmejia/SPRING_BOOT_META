package com.riwi.primeraweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    /*
     * Método para listar los coders de forma paginada
     */
    public Page<Coder> fingPaginated(int page, int size) {
        if (page < 0) {
            page = 1;
        }

        // Crear objeto de paginación
        Pageable objPageable = PageRequest.of(page, size);

        return this.objCoderRepository.findAll(objPageable);
    }

    /**
     * Servicio para guardar un coder
     */

    public Coder insert(Coder objCoder) {
        return this.objCoderRepository.save(objCoder);
    }

    /**
     * Servicio para actualizar un coder
     */

    public Coder update(Long id, Coder objCoder) {
        /** Buscar al coder con ese id */
        Coder objCoderDB = this.findById(id);

        /** Verificar que si exista */
        if (objCoderDB == null)
            return null;

        /* Actualizar el coder antiguo */
        objCoderDB = objCoder;

        // Guardarlo
        return this.objCoderRepository.save(objCoderDB);
    }

    public Coder findById(Long id) {
        return this.objCoderRepository.findById(id).orElse(null);
    }

    /**
     * Metodo para eliminar
     *
     */

    public void delete(Long id) {
        this.objCoderRepository.deleteById(id);
    }
}
