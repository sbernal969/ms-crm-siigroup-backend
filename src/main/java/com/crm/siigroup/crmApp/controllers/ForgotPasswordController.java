package com.crm.siigroup.crmApp.controllers;

import com.crm.siigroup.crmApp.dto.in.ForgotPasswordIn;
import com.crm.siigroup.crmApp.dto.in.UserIn;
import com.crm.siigroup.crmApp.dto.out.CustomerCreatedOut;
import com.crm.siigroup.crmApp.dto.out.ForgotPasswordOut;
import com.crm.siigroup.crmApp.dto.out.Response;
import com.crm.siigroup.crmApp.models.service.ForgotPasswordServive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "v1/forgotpassword")
public class ForgotPasswordController {

    @Autowired(required = true)
    private ForgotPasswordServive forgotPasswordService;

    private static final Logger logger = LoggerFactory.getLogger(ForgotPasswordController.class.getSimpleName());

    @PostMapping("post")
    public ResponseEntity<Response<ForgotPasswordOut>> postForgotPasswordController(@RequestBody() ForgotPasswordIn forgotPasswordIn) throws Exception {
        logger.info("Ingresa al Forgot Password");
        ForgotPasswordOut forgotPasswordOut = forgotPasswordService.postForgotPassword(forgotPasswordIn);
        Response<ForgotPasswordOut> response = new Response<>(HttpStatus.CREATED.value(), "OK", forgotPasswordOut);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
