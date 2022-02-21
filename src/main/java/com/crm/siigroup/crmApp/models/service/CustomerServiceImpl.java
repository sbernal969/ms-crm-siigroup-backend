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

import java.text.ParseException;
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
           customerOut.setNacionalityName(customers.getNationality().getGlosa());
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
    public CustomerCreatedOut postCustomer(CustomerIn customerIn) throws ParseException {


        CustomerCreatedOut customerCreatedOut = new CustomerCreatedOut();
        Customers customers = new Customers();
        Customers validaCustomer = new Customers();

        Country country = new Country();
        Nationality nationality = new Nationality();
        Gender gender = new Gender();
        Country mobileNumberCode = new Country();
        Country fixNumberCode = new Country();
        Country addressCountry = new Country();
        Currency currency = new Currency();

        validaCustomer = customerRepository.findCustomersByPersonalId(customerIn.getPersonalId());

        if (validaCustomer == null) {

            country.setCountryId(customerIn.getCountry());
            nationality.setNationalityId(customerIn.getNationality());
            gender.setGenderId(customerIn.getGender());
            mobileNumberCode.setCountryId(customerIn.getMobileNumberCode());
            fixNumberCode.setCountryId(customerIn.getMobileNumberCode());
            addressCountry.setCountryId(customerIn.getAddressCountry());
            currency.setCurrencyId(customerIn.getCurrency());


            customers.setPersonalId(customerIn.getPersonalId());
            customers.setName(customerIn.getName());
            customers.setFamilyFirstName(customerIn.getFamilyFirstName());
            customers.setFamilySecondName(customerIn.getFamilySecondName());
            customers.setBirth(customerIn.getBirth());
            customers.setCountry(country);
            customers.setNationality(nationality);
            customers.setGender(gender);
            customers.setEmail(customerIn.getEmail());
            customers.setMobileNumber(customerIn.getMobileNumber());
            customers.setMobileNumberCode(mobileNumberCode);
            customers.setFixNumber(customerIn.getFixNumber());
            customers.setFixNumberCode(fixNumberCode);
            customers.setAddressCountry(addressCountry);
            customers.setAddressStreet(customerIn.getAddressStreet());
            customers.setAddressNumber(customerIn.getAddressNumber());
            customers.setAddressComune(customerIn.getAddressComune());
            customers.setAddressPostalCode(customerIn.getAddressPostalCode());
            customers.setAddressCity(customerIn.getAddressCity());
            customers.setAddressAditional(customerIn.getAddressAditional());
            customers.setIncome(customerIn.getIncome());
            customers.setCurrency(currency);
            customers.setTipeOfClient(customerIn.getTipeOfClient());

            customerRepository.save(customers);

            customerCreatedOut.setCustomerCreated(true);
            customerCreatedOut.setMessage("Usuario creado correctamente");
            customerCreatedOut.setIdCustomer(customers.getId());
        }else{
            customerCreatedOut.setCustomerCreated(false);
            customerCreatedOut.setMessage("Usuario ya existe");
            customerCreatedOut.setIdCustomer(validaCustomer.getId());
        }
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
        customerOut.setNacionalityName(customers.getNationality().getGlosa());
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
