package com.crm.siigroup.crmApp.models.service;


import com.crm.siigroup.crmApp.controllers.CustomerController;
import com.crm.siigroup.crmApp.dto.in.CustomerIn;
import com.crm.siigroup.crmApp.dto.out.CustomerCreatedOut;
import com.crm.siigroup.crmApp.dto.out.CustomerOut;
import com.crm.siigroup.crmApp.models.entity.*;
import com.crm.siigroup.crmApp.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class.getSimpleName());

    @Override
    public List<CustomerOut> getCustomer() throws Exception {

        CustomerOut customerOut = new CustomerOut();
        List<CustomerOut> customerOutList = new ArrayList<CustomerOut>();
        List <Customers>  customersList = customerRepository.findAll();

       for (Customers customers:customersList){
           customerOut.setPersonalId(customers.getPersonalId());
           customerOut.setName(customers.getName());
           customerOut.setFamilyFirstName(customers.getFamilyFirstName());
           customerOut.setFamilySecondName(customers.getFamilySecondName());
           customerOut.setBirth(customers.getBirth());
           customerOut.setCountryId(customers.getCountry().getCountryId());
           customerOut.setCountryName(customers.getCountry().getName());
           customerOut.setNationalityId(customers.getNationality().getNationalityId());
           customerOut.setNacionalityName(customers.getName());
           customerOut.setGenderId(customers.getGender().getGenderId());
           customerOut.setGenderType(customers.getGender().getGlosa());
           customerOut.setEmail(customers.getEmail());
           customerOut.setMobileNumberId(customers.getMobileNumberCode().getCountryId());
           customerOut.setMobileNumber(customers.getMobileNumber());
           customerOut.setMobileNumberCode(customers.getMobileNumberCode().getCode());
           customerOut.setFixNumberId(customers.getFixNumberCode().getCountryId());
           customerOut.setFixNumber(customers.getFixNumber());
           customerOut.setFixNumberCode(customers.getFixNumberCode().getCode());
           customerOut.setAddressCountryId(customers.getAddressCountry().getCountryId());
           customerOut.setAddressCountryName(customers.getAddressCountry().getName());
           customerOut.setAddressStreet(customers.getAddressStreet());
           customerOut.setAddressNumber(customers.getAddressNumber());

           //customerOut.setAddressComuneId(customers.getAddressComune().getCommunesId());
           //customerOut.setAddressComuneName(customers.getAddressComune().getGlosa());
           customerOut.setAddressComune(customers.getAddressComune());

           customerOut.setAddressPostalCode(customers.getAddressPostalCode());
           customerOut.setAddressCity(customers.getAddressCity());
           customerOut.setAddressAditional(customers.getAddressAditional());
           customerOut.setIncome(customers.getIncome());
           customerOut.setCurrencyId(customers.getCurrency().getCurrencyId());
           customerOut.setCurrencyName(customers.getCurrency().getGlosa());
           customerOut.setTipeOfClient(customers.getTipeOfClient());

            customerOutList.add(customerOut);
        }

        return customerOutList;
    }

    //Implementación del método postCustomer
    @Override
    public CustomerCreatedOut postCustomer(CustomerIn customerIn) {

        CustomerCreatedOut customerCreatedOut = new CustomerCreatedOut();
        Customers customers = new Customers();

        customers.setPersonalId(customerIn.getRut());
        customers.setName(customerIn.getName());
        customers.setFamilyFirstName(customerIn.getFamilyFirstName());
        customers.setFamilySecondName(customerIn.getFamilySecondName());
        customers.setBirth(customerIn.getBirth());
        customers.setCountry(customerIn.getCountry());

        customers.setNationality(customerIn.getNationality());
        customers.setGender(customerIn.getGender());
        customers.setEmail(customerIn.getEmail());
        customers.setMobileNumber(customerIn.getMobileNumber());
        customers.setMobileNumberCode(customerIn.getMobileNumberCode());
        customers.setFixNumber(customerIn.getFixNumber());
        customers.setFixNumberCode(customerIn.getFixNumberCode());
        customers.setAddressCountry(customerIn.getAddressCountry());
        customers.setAddressStreet(customerIn.getAddressStreet());
        customers.setAddressNumber(customerIn.getAddressNumber());


        customers.setAddressComune(customerIn.getAddressComune());


        customers.setAddressPostalCode(customerIn.getAddressPostalCode());
        customers.setAddressCity(customerIn.getAddressCity());
        customers.setAddressAditional(customerIn.getAddressAditional());
        customers.setIncome(customerIn.getIncome());
        customers.setCurrency(customerIn.getCurrency());
        customers.setTipeOfClient(customerIn.getTipeOfClient());

        customerRepository.save(customers);

            customerCreatedOut.setCustomerCreated(true);
            customerCreatedOut.setMessage("Usuario creado correctamente");
            customerCreatedOut.setIdCustomer(customers.getId());

        return customerCreatedOut;
    }

    @Override
    public CustomerOut getViewCustomer(Long customerId) throws Exception {

        CustomerOut customerOut = new CustomerOut();
        Customers customers = new Customers();

        customers = customerRepository.findCustomersById(customerId);

        customerOut.setPersonalId(customers.getPersonalId());
        customerOut.setName(customers.getName());
        customerOut.setFamilyFirstName(customers.getFamilyFirstName());
        customerOut.setFamilySecondName(customers.getFamilySecondName());
        customerOut.setBirth(customers.getBirth());
        customerOut.setCountryId(customers.getCountry().getCountryId());
        customerOut.setCountryName(customers.getCountry().getName());
        customerOut.setNationalityId(customers.getNationality().getNationalityId());
        customerOut.setNacionalityName(customers.getName());
        customerOut.setGenderId(customers.getGender().getGenderId());
        customerOut.setGenderType(customers.getGender().getGlosa());
        customerOut.setEmail(customers.getEmail());
        customerOut.setMobileNumberId(customers.getMobileNumberCode().getCountryId());
        customerOut.setMobileNumber(customers.getMobileNumber());
        customerOut.setMobileNumberCode(customers.getMobileNumberCode().getCode());
        customerOut.setFixNumberId(customers.getFixNumberCode().getCountryId());
        customerOut.setFixNumber(customers.getFixNumber());
        customerOut.setFixNumberCode(customers.getFixNumberCode().getCode());
        customerOut.setAddressCountryId(customers.getAddressCountry().getCountryId());
        customerOut.setAddressCountryName(customers.getAddressCountry().getName());
        customerOut.setAddressStreet(customers.getAddressStreet());
        customerOut.setAddressNumber(customers.getAddressNumber());
        //customerOut.setAddressComuneId(customers.getAddressComune().getCommunesId());
        //customerOut.setAddressComuneName(customers.getAddressComune().getGlosa());
        customerOut.setAddressComune(customers.getAddressComune());
        customerOut.setAddressPostalCode(customers.getAddressPostalCode());
        customerOut.setAddressCity(customers.getAddressCity());
        customerOut.setAddressAditional(customers.getAddressAditional());
        customerOut.setIncome(customers.getIncome());
        customerOut.setCurrencyId(customers.getCurrency().getCurrencyId());
        customerOut.setCurrencyName(customers.getCurrency().getGlosa());
        customerOut.setTipeOfClient(customers.getTipeOfClient());

        return customerOut;
    }

}
