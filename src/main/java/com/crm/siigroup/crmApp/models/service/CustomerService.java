package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.dto.in.CustomerId;
import com.crm.siigroup.crmApp.dto.in.CustomerIn;
import com.crm.siigroup.crmApp.dto.out.CustomerCreatedOut;
import com.crm.siigroup.crmApp.dto.out.CustomerOut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    List<CustomerOut> getCustomer() throws Exception;

    CustomerCreatedOut postCustomer(CustomerIn customerIn) throws Exception;

    CustomerOut getViewCustomer(Long customerId) throws Exception;
}
