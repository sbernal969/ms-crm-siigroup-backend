package com.crm.siigroup.crmApp.controllers;

import com.crm.siigroup.crmApp.dto.in.CustomerFilter;
import com.crm.siigroup.crmApp.dto.in.CustomerIn;
import com.crm.siigroup.crmApp.dto.out.CustomerCreatedOut;
import com.crm.siigroup.crmApp.dto.out.CustomerOut;
import com.crm.siigroup.crmApp.dto.out.Response;
import com.crm.siigroup.crmApp.models.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "v1/customers")
public class CustomerController {

    @Autowired(required = true)
    private CustomerService customerService;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class.getSimpleName());

    @GetMapping("get")
    public ResponseEntity<Response<List<CustomerOut>>> getCustomer() throws Exception {
        logger.info("getCustomers");
        List<CustomerOut> customerOutList = customerService.getCustomer();
        Response<List<CustomerOut>> response = new Response<>(HttpStatus.CREATED.value(), "OK", customerOutList);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("create")
    public ResponseEntity<Response<CustomerCreatedOut>> postCustomerController(@RequestBody() CustomerIn customerIn) throws Exception {
        logger.info("Ingresa a la creación de Customer");
        CustomerCreatedOut customerCreatedOut = customerService.postCustomer(customerIn);
        Response<CustomerCreatedOut> response = new Response<>(HttpStatus.CREATED.value(), "OK", customerCreatedOut);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("getCustomerById")
    public ResponseEntity<Response<CustomerOut>> getViewCustomer(@RequestParam Long customerId) throws Exception {
        logger.info("getViewCustomers");
        CustomerOut customerOut = customerService.getViewCustomer(customerId);
        Response<CustomerOut> response = new Response<>(HttpStatus.CREATED.value(), "OK", customerOut);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("search")
    public ResponseEntity<Response<List<CustomerOut>>> postCustomerFilter(@RequestBody CustomerFilter filter) throws Exception {
        logger.info("search");
        List<CustomerOut> customerOutList = customerService.getCustomerByFilter(filter);
        Response<List<CustomerOut>> response = new Response<>(HttpStatus.CREATED.value(), "OK", customerOutList);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
