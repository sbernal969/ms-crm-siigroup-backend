package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.dto.out.CountryOut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {

    List<CountryOut> getCountry() throws Exception;
}
