package com.riwi.beautySalon.infraestructure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.beautySalon.api.dto.request.ClientReq;
import com.riwi.beautySalon.api.dto.response.AppointmentToClient;
import com.riwi.beautySalon.api.dto.response.ClientResp;
import com.riwi.beautySalon.api.dto.response.EmployeeResp;
import com.riwi.beautySalon.api.dto.response.ServiceResp;
import com.riwi.beautySalon.domain.entities.Appointment;
import com.riwi.beautySalon.domain.entities.ClientEntity;
import com.riwi.beautySalon.domain.repositories.ClientRepository;
import com.riwi.beautySalon.infraestructure.abstract_services.IClientService;
import com.riwi.beautySalon.utils.enums.SortType;
import com.riwi.beautySalon.utils.exception.BadRequestException;
import com.riwi.beautySalon.utils.messages.ErrorMessages;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ClientService implements IClientService{

    @Autowired
    private final ClientRepository clientRepository;


    @Override
    public ClientResp create(ClientReq request) {
        ClientEntity client = this.requestToEntity(request);
        client.setAppointments(new ArrayList<>());
        return this.entityToResp(this.clientRepository.save(client));
    }

    @Override
    public ClientResp get(Long id) {
        return this.entityToResp(this.find(id));
    }

    @Override
    public ClientResp update(ClientReq request, Long id) {
        ClientEntity client = this.find(id);

        ClientEntity clientUpdate = this.requestToEntity(request);
        clientUpdate.setId(id);
        clientUpdate.setAppointments(client.getAppointments());

        return this.entityToResp(this.clientRepository.save(clientUpdate));
    }

    @Override
    public void delete(Long id) {
        ClientEntity client = this.find(id);
        this.clientRepository.delete(client);
    }

    @Override
    public Page<ClientResp> getAll(int page, int size, SortType sortType) {
        
        if (page <0) page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }
        
        return this.clientRepository.findAll(pagination)
                .map(this::entityToResp);
    }
    
    private ClientResp entityToResp(ClientEntity entity){

       List<AppointmentToClient> appointments = entity.getAppointments()
            .stream()
            .map(this::entityToResponseAppointment)
            .collect(Collectors.toList());

        return ClientResp.builder()
                 .id(entity.getId())
                 .firstName(entity.getFirstName())
                 .lastName(entity.getLastName())
                 .phone(entity.getPhone())
                 .email(entity.getEmail())
                 .appointments(appointments)
                 .build();

    }

    private AppointmentToClient entityToResponseAppointment(Appointment entity){

        ServiceResp service = new ServiceResp();
        BeanUtils.copyProperties(entity.getService(), service);

        EmployeeResp employee = new EmployeeResp();
        BeanUtils.copyProperties(entity.getEmployee(), employee);

        return AppointmentToClient.builder()
                    .id(entity.getId())
                    .dateTime(entity.getDateTime())
                    .duration(entity.getDuration())
                    .comments(entity.getComments())
                    .service(service)
                    .employee(employee)
                    .build();

    }

    private ClientEntity requestToEntity(ClientReq client) {
        return ClientEntity.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .phone(client.getPhone())
                .email(client.getEmail())
                .build();
    }

    private ClientEntity find(Long id) {
        return this.clientRepository.findById(id)
                    .orElseThrow(()-> new BadRequestException(ErrorMessages.idNotFound("Client")));
    }
}
