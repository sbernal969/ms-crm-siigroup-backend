package com.crm.siigroup.crmApp.controllers;

import com.crm.siigroup.crmApp.dto.out.CommunesOut;
import com.crm.siigroup.crmApp.dto.out.CountryOut;
import com.crm.siigroup.crmApp.dto.out.Response;
import com.crm.siigroup.crmApp.models.service.CommunesService;
import com.crm.siigroup.crmApp.models.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "v1/country")
public class CountryController {

    @Autowired(required = true)
    private CountryService countryService;

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class.getSimpleName());

    @GetMapping("get")
    public ResponseEntity<Response<List<CountryOut>>> CountryController() throws Exception {
        logger.info("Ingresa a los paises");
        List<CountryOut> countryOut = countryService.getCountry();
        Response<List<CountryOut>> response = new Response<>(HttpStatus.CREATED.value(), "OK", countryOut);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
