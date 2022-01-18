package com.crm.siigroup.crmApp.controllers;

import com.crm.siigroup.crmApp.dto.in.UserIn;
import com.crm.siigroup.crmApp.dto.out.LoginOut;
import com.crm.siigroup.crmApp.dto.out.Response;
import com.crm.siigroup.crmApp.models.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "v1/login")
public class LoginController {
    @Autowired(required = true) private LoginService loginService;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class.getSimpleName());

    @PostMapping("user")
    public ResponseEntity<Response<LoginOut>> postLogin(@RequestBody() UserIn userIn) throws Exception {
        logger.info("Ingresa al Login");
        LoginOut loginOut = loginService.postLogin(userIn);
        Response<LoginOut> response = new Response<>(HttpStatus.CREATED.value(), "OK", loginOut);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
