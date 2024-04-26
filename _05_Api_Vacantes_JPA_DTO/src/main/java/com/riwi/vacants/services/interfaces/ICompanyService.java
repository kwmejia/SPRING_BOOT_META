package com.riwi.vacants.services.interfaces;

import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;

public interface ICompanyService
        extends CrudService<CompanyRequest, CompanyResponse, String> {

}
