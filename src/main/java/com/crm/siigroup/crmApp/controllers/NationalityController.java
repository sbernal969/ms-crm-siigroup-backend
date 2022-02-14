package com.crm.siigroup.crmApp.controllers;

import com.crm.siigroup.crmApp.dto.out.CurrencyOut;
import com.crm.siigroup.crmApp.dto.out.NationalityOut;
import com.crm.siigroup.crmApp.dto.out.Response;
import com.crm.siigroup.crmApp.models.service.NationalityService;
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
@RequestMapping(value = "v1/nationality")
public class NationalityController {

    @Autowired(required = true)
    private NationalityService nationalityService;

    private static final Logger logger = LoggerFactory.getLogger(NationalityController.class.getSimpleName());

    @GetMapping("get")
    public ResponseEntity<Response<List<NationalityOut>>> NationalityController() throws Exception {
        logger.info("Ingresa a la Nacionalidad");
        List<NationalityOut> nationalityOut = nationalityService.getNationality();
        Response<List<NationalityOut>> response = new Response<>(HttpStatus.CREATED.value(), "OK", nationalityOut);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
