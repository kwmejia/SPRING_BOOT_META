package com.riwi.beautySalon.infraestructure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riwi.beautySalon.api.dto.request.ServiceReq;
import com.riwi.beautySalon.api.dto.response.ServiceResp;
import com.riwi.beautySalon.domain.entities.ServiceEntity;
import com.riwi.beautySalon.domain.repositories.ServiceRepository;
import com.riwi.beautySalon.infraestructure.abstract_services.IServiceService;
import com.riwi.beautySalon.utils.enums.SortType;
import com.riwi.beautySalon.utils.exception.BadRequestException;
import com.riwi.beautySalon.utils.messages.ErrorMessages;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ServiceService implements IServiceService {

    @Autowired
    private final ServiceRepository serviceRepository;

    @Override
    public ServiceResp create(ServiceReq request) {
       ServiceEntity service = this.requestToEntity(request);

       return this.entityToResp(this.serviceRepository.save(service));
    }

    @Override
    public ServiceResp get(Long id) {
       return this.entityToResp(this.find(id));
    }

    @Override
    public ServiceResp update(ServiceReq request, Long id) {
        ServiceEntity service = this.find(id);

        service = this.requestToEntity(request);

        service.setId(id);

        return this.entityToResp(this.serviceRepository.save(service));
    }

    @Override
    public void delete(Long id) {
       this.serviceRepository.delete(this.find(id));
    }

    @Override
    public Page<ServiceResp> getAll(int page, int size, SortType sortType) {
      if (page < 0) page = 0;
      
      PageRequest pagination = null;

      switch (sortType) {
          case NONE -> pagination = PageRequest.of(page, size);
          case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
          case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
      }

      this.serviceRepository.findAll(pagination);

      return this.serviceRepository.findAll(pagination)
        .map(this::entityToResp);

    }

    @Override
    public List<ServiceResp> search(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }


    private ServiceResp entityToResp(ServiceEntity entity){

        return ServiceResp.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .build();
    }
    

    private ServiceEntity requestToEntity(ServiceReq request){

        return ServiceEntity.builder()
                    .name(request.getName())
                    .price(request.getPrice())
                    .description(request.getDescription())
                    .build();
    }

    private ServiceEntity  find(Long id ){

        return this.serviceRepository.findById(id)
            .orElseThrow(()-> new BadRequestException(ErrorMessages.idNotFound("Servicio")));
    }
}
