package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.dto.out.CustomerOut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    List<CustomerOut> getCustomer() throws Exception;
}
