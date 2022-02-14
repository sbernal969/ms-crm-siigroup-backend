package com.crm.siigroup.crmApp.controllers;

import com.crm.siigroup.crmApp.dto.out.CommunesOut;
import com.crm.siigroup.crmApp.dto.out.GenderOut;
import com.crm.siigroup.crmApp.dto.out.Response;
import com.crm.siigroup.crmApp.models.service.CommunesService;
import com.crm.siigroup.crmApp.models.service.GenderService;
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
@RequestMapping(value = "v1/gender")
public class GenderController {

    @Autowired(required = true)
    private GenderService genderService;

    private static final Logger logger = LoggerFactory.getLogger(GenderController.class.getSimpleName());

    @GetMapping("get")
    public ResponseEntity<Response<List<GenderOut>>> GenderController() throws Exception {
        logger.info("Ingresa al tipo de género");
        List<GenderOut> genderOut = genderService.getGender();
        Response<List<GenderOut>> response = new Response<>(HttpStatus.CREATED.value(), "OK", genderOut);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
