package com.crm.siigroup.crmApp.controllers;

import com.crm.siigroup.crmApp.dto.out.CurrencyOut;
import com.crm.siigroup.crmApp.dto.out.Response;
import com.crm.siigroup.crmApp.models.service.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "v1/currency")
public class CurrencyController {

    @Autowired(required = true)
    private CurrencyService currencyService;

    private static final Logger logger = LoggerFactory.getLogger(CurrencyController.class.getSimpleName());

    @GetMapping("get")
    public ResponseEntity<Response<List<CurrencyOut>>> CurrencyController() throws Exception {
        logger.info("Ingresa al tipo de moneda: currency");
        List<CurrencyOut> currencyOut = currencyService.getCurrency();
        Response<List<CurrencyOut>> response = new Response<>(HttpStatus.CREATED.value(), "OK", currencyOut);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
