package com.crm.siigroup.crmApp.controllers;

import com.crm.siigroup.crmApp.dto.out.CodeAreaOut;
import com.crm.siigroup.crmApp.dto.out.CommunesOut;
import com.crm.siigroup.crmApp.dto.out.Response;
import com.crm.siigroup.crmApp.models.service.CodeAreaService;
import com.crm.siigroup.crmApp.models.service.CommunesService;
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
@RequestMapping(value = "v1/code")
public class CodeAreaController {

    @Autowired(required = true)
    private CodeAreaService codeAreaService;

    private static final Logger logger = LoggerFactory.getLogger(CodeAreaController.class.getSimpleName());

    @GetMapping("get")
    public ResponseEntity<Response<List<CodeAreaOut>>> CodeAreaController() throws Exception {
        logger.info("Ingresa a las comunas");
        List<CodeAreaOut> codeAreaOut = codeAreaService.getCodeArea();
        Response<List<CodeAreaOut>> response = new Response<>(HttpStatus.CREATED.value(), "OK", codeAreaOut);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
