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

import com.riwi.beautySalon.api.dto.request.AppointmentReq;
import com.riwi.beautySalon.api.dto.response.AppointmentResp;
import com.riwi.beautySalon.infraestructure.abstract_services.IAppointmentService;
import com.riwi.beautySalon.utils.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/appointments")
@AllArgsConstructor
public class AppointmentController {

    private final IAppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<Page<AppointmentResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader(required = false) SortType sortType) {
        if (Objects.isNull(sortType))
            sortType = SortType.NONE;

        return ResponseEntity.ok(this.appointmentService.getAll(page - 1, size, sortType));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AppointmentResp> get(
            @PathVariable Long id) {
        return ResponseEntity.ok(this.appointmentService.get(id));
    }

    @PostMapping
    public ResponseEntity<AppointmentResp> insert(
            @Validated @RequestBody AppointmentReq request) {
        return ResponseEntity.ok(this.appointmentService.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AppointmentResp> update(
            @Validated @RequestBody AppointmentReq request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.appointmentService.update(request, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
