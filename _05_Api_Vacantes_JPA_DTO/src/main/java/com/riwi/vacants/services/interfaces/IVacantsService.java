package com.riwi.vacants.services.interfaces;

import com.riwi.vacants.utils.dto.request.VacantRequest;
import com.riwi.vacants.utils.dto.response.VacantResponse;

/**
 * Interface para establecer en contrato con el servicio
 */
public interface IVacantsService extends CrudService<VacantRequest, VacantResponse, Long> {

}
