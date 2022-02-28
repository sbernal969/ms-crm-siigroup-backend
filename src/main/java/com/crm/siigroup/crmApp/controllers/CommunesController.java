package com.crm.siigroup.crmApp.controllers;

import com.crm.siigroup.crmApp.dto.out.CommunesOut;
import com.crm.siigroup.crmApp.dto.out.CurrencyOut;
import com.crm.siigroup.crmApp.dto.out.Response;
import com.crm.siigroup.crmApp.models.service.CommunesService;
import com.crm.siigroup.crmApp.models.service.CurrencyService;
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
@RequestMapping(value = "v1/communes")
public class CommunesController {

    @Autowired(required = true)
    private CommunesService communesService;
    

    private static final Logger logger = LoggerFactory.getLogger(CommunesController.class.getSimpleName());

    @GetMapping("get")
    public ResponseEntity<Response<List<CommunesOut>>> CommunesController() throws Exception {
        logger.info("Ingresa a las comunas");
        List<CommunesOut> communesOut = communesService.getCommunes();
        Response<List<CommunesOut>> response = new Response<>(HttpStatus.CREATED.value(), "OK", communesOut);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
