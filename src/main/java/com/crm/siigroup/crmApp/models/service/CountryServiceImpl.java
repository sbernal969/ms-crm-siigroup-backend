package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.controllers.CountryController;
import com.crm.siigroup.crmApp.dto.out.CountryOut;
import com.crm.siigroup.crmApp.models.entity.Country;
import com.crm.siigroup.crmApp.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class.getSimpleName());

    @Override
    public List<CountryOut> getCountry() throws Exception {
       CountryOut countryOut = new CountryOut();
       List<Country> countryList = new ArrayList<>();
       List<CountryOut> countryOutList = new ArrayList<>();

       countryList = countryRepository.findAll();

       try {
           for (Country countryResponse : countryList) {
               countryOut = new CountryOut();
               countryOut.setId(countryResponse.getCountryId());
               countryOut.setName(countryResponse.getName());
               countryOut.setCode(countryResponse.getCode());
               countryOutList.add(countryOut);
           }
       }catch (Exception ex){
           logger.info(ex.getMessage());
       }

        return countryOutList;
    }
}
