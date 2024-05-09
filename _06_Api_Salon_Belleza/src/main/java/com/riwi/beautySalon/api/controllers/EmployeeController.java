package com.riwi.beautySalon.api.controllers;

import java.util.Objects;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.beautySalon.api.dto.request.EmployeeReq;
import com.riwi.beautySalon.api.dto.response.EmployeeResp;
import com.riwi.beautySalon.infraestructure.abstract_services.IEmployeeService;
import com.riwi.beautySalon.utils.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/employees")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    private final IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Page<EmployeeResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader(required = false) SortType sortType) {
        if (Objects.isNull(sortType))
            sortType = SortType.NONE;

        return ResponseEntity.ok(this.employeeService.getAll(page - 1, size, sortType));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EmployeeResp> get(
            @PathVariable Long id) {
        return ResponseEntity.ok(this.employeeService.get(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeResp> insert(
            @Validated @RequestBody EmployeeReq request) {
        return ResponseEntity.ok(this.employeeService.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EmployeeResp> update(
            @Validated @RequestBody EmployeeReq request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.employeeService.update(request, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}