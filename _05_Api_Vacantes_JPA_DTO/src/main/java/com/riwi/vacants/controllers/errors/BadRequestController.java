package com.riwi.vacants.controllers.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.riwi.vacants.utils.dto.errors.BaseErrorResponse;
import com.riwi.vacants.utils.dto.errors.ErrorResponse;
import com.riwi.vacants.utils.exceptions.IdNotFoundExeption;

/**
 * RestControllerAdvice = Controlador de errorres
 */
@RestControllerAdvice
/**
 * Status de error
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {

    /**
     * Para especificar cuando se va a disparar este metodo
     * utilizamos la aotacion ExceptionHandler
     */
    @ExceptionHandler(IdNotFoundExeption.class)
    public BaseErrorResponse handleIdNotFound(IdNotFoundExeption exeption) {

        return ErrorResponse.builder()
                .message(exeption.getMessage())
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();

        // ErrorResponse error = new ErrorResponse()
        // error.setMessage(exeption.getMessage());
        // error.setStatus(HttpStatus.BAD_REQUEST.name()));
        // error.code(HttpStatus.BAD_REQUEST.value());

    }
}
