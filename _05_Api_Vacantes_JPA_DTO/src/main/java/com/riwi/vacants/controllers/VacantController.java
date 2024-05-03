package com.riwi.vacants.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.vacants.services.interfaces.IVacantsService;
import com.riwi.vacants.utils.dto.request.VacantRequest;
import com.riwi.vacants.utils.dto.response.VacantResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/vacants")
@AllArgsConstructor
public class VacantController {

    @Autowired
    private final IVacantsService vacantsService;

    @GetMapping
    public ResponseEntity<Page<VacantResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "7") int size) {

        return ResponseEntity.ok(this.vacantsService.getAll(page - 1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<VacantResponse> get(
            @PathVariable Long id) {

        return ResponseEntity.ok(this.vacantsService.getById(id));
    }

    @PostMapping
    public ResponseEntity<VacantResponse> insert(
            @Validated @RequestBody VacantRequest vacant) {
        return ResponseEntity.ok(this.vacantsService.create(vacant));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String, String>> delete(
            @PathVariable Long id) {

        // Creamos el mapa
        Map<String, String> response = new HashMap<>();

        response.put("message", "Vacante eliminada correctamente.");

        this.vacantsService.delete(id);

        return ResponseEntity.ok(response);

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<VacantResponse> update(
            @PathVariable Long id,
            @Validated @RequestBody VacantRequest vacant) {

        return ResponseEntity.ok(this.vacantsService.update(vacant, id));
    }
}
