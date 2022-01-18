package com.crm.siigroup.crmApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "v1/siiGroup/customers")
public class CustomerController {

 /*   @Autowired
    private CustomerService customerService;

    @GetMapping("get")
    public ResponseEntity<Response<List<CustomerOut>>> getCustomer() throws Exception {
        List<CustomerOut> customers = customerService.getCustomer();
        Response<List<CustomerOut>> response = new Response<>(HttpStatus.CREATED.value(), "OK", customers);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

  */
}
