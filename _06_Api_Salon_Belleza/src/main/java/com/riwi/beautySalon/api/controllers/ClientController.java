package com.riwi.beautySalon.api.controllers;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.beautySalon.api.dto.request.ClientReq;
import com.riwi.beautySalon.api.dto.response.ClientResp;
import com.riwi.beautySalon.infraestructure.abstract_services.IClientService;
import com.riwi.beautySalon.utils.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/clients")
@AllArgsConstructor
public class ClientController {
    private final IClientService clientService;

    @GetMapping
    public ResponseEntity<Page<ClientResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader(required = false) SortType sortType) {
        if (Objects.isNull(sortType))
            sortType = SortType.NONE;

        return ResponseEntity.ok(this.clientService.getAll(page - 1, size, sortType));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientResp> get(
            @PathVariable Long id) {
        return ResponseEntity.ok(this.clientService.get(id));
    }

    @PostMapping
    public ResponseEntity<ClientResp> insert(
            @Validated @RequestBody ClientReq request) {
        return ResponseEntity.ok(this.clientService.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ClientResp> update(
            @Validated @RequestBody ClientReq request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.clientService.update(request, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}