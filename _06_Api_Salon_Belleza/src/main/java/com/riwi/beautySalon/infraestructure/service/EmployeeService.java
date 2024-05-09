package com.riwi.beautySalon.infraestructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.beautySalon.api.dto.request.EmployeeReq;
import com.riwi.beautySalon.api.dto.response.EmployeeResp;
import com.riwi.beautySalon.domain.entities.Employee;
import com.riwi.beautySalon.domain.repositories.EmployeeRepository;
import com.riwi.beautySalon.infraestructure.abstract_services.IEmployeeService;
import com.riwi.beautySalon.utils.enums.SortType;
import com.riwi.beautySalon.utils.exception.BadRequestException;
import com.riwi.beautySalon.utils.messages.ErrorMessages;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Override
    public Page<EmployeeResp> getAll(int page, int size, SortType sortType) {
        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.employeeRepository.findAll(pagination)
                .map(this::entityToResponse);
    }

    @Override
    public EmployeeResp create(EmployeeReq request) {
        Employee entity = this.requestToEntity(request);
        return this.entityToResponse(this.employeeRepository.save(entity));
    }

    @Override
    public EmployeeResp get(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public EmployeeResp update(EmployeeReq request, Long id) {
        Employee employee = this.find(id);
        employee = this.requestToEntity(request);
        employee.setId(id);

        return this.entityToResponse(this.employeeRepository.save(employee));
    }

    @Override
    public void delete(Long id) {
        this.employeeRepository.delete(this.find(id));
    }

    private Employee find(Long id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(()-> new BadRequestException(ErrorMessages.idNotFound("Servicio")));
    }

    private EmployeeResp entityToResponse(Employee entity) {
        return EmployeeResp.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .role(entity.getRole())
                .build();

    }

    private Employee requestToEntity(EmployeeReq request) {
        return Employee.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .role(request.getRole())
                .build();
    }

}