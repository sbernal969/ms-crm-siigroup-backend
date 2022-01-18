package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.dto.out.CustomerOut;
import com.crm.siigroup.crmApp.models.entity.Customers;
import com.crm.siigroup.crmApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<CustomerOut> getCustomer() throws Exception {

        CustomerOut customerOut = new CustomerOut();
        List<CustomerOut> customerOutList = new ArrayList<CustomerOut>();
        List <Customers> customersList = new ArrayList<Customers>();

        customersList = customerRepository.findAll();

        for (Customers customers:customersList){
            customerOut.setRut(customers.getRut());
            customerOut.setFirstName(customers.getFirstName());
            customerOut.setFamilyName(customers.getFamilyName());
            customerOut.setBirth(customers.getBirth());
            customerOut.setCountry(customers.getCountry());
            customerOut.setNacionality(customers.getNacionality());
            customerOut.setGender(customers.getGender());
            customerOut.setEmail(customers.getEmail());
            customerOut.setMobileNumber(customers.getMobileNumber());
            customerOut.setFixNumber(customers.getFixNumber());
            customerOut.setPostalAddress(customers.getPostalAddress());
            customerOut.setIncome(customers.getIncome());
            customerOut.setTipeOfClient(customers.getTipeOfClient());

            customerOutList.add(customerOut);
        }

        return customerOutList;
    }
}
