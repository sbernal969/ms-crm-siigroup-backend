package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.controllers.CustomerController;
import com.crm.siigroup.crmApp.dto.in.CustomerFilter;
import com.crm.siigroup.crmApp.dto.in.CustomerIn;
import com.crm.siigroup.crmApp.dto.out.CustomerCreatedOut;
import com.crm.siigroup.crmApp.dto.out.CustomerOut;
import com.crm.siigroup.crmApp.models.entity.*;
import com.crm.siigroup.crmApp.models.specifications.CustomersSpecifications;
import com.crm.siigroup.crmApp.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class.getSimpleName());

    //Visualizar customers.
    @Override
    public List<CustomerOut> getCustomer() throws Exception {

        return convertListToCustomerOutList(customerRepository.findAll());
    }

    //Implementación del método postCustomer customerCreate.
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

    //Visualización de customers por id.
    @Override
    public CustomerOut getViewCustomer(Long customerId) throws Exception {

        return convertToCustomerOut(customerRepository.findCustomersById(customerId));
    }

    @Override
    public List<CustomerOut> getCustomerByFilter(CustomerFilter customerFilter) throws Exception {

        Currency currency = null;
        if(customerFilter.getIdCurrency()!=null){
            currency = new Currency();
            currency.setCurrencyId(customerFilter.getIdCurrency());
        }

        Integer typeOfClient = 0;
        boolean bothClientTrue = customerFilter.isCustomer() && customerFilter.isProspect() ? true : false;
        boolean bothClientFalse = customerFilter.isCustomer() && customerFilter.isProspect() ? false : true;

        if (bothClientTrue || bothClientFalse){
            typeOfClient = null;
        }else{
            typeOfClient = customerFilter.isCustomer() ? 1 : 0;
        }

        Specification<Customers> spec = Specification
                .where(customerFilter.getPersonalId() == null ? null : CustomersSpecifications.personalIdContains(customerFilter.getPersonalId()))
                .and(customerFilter.getName() == null ? null : CustomersSpecifications.nameContains(customerFilter.getName()))
                .and(customerFilter.getFamilyFirstName() == null ? null : CustomersSpecifications.familyFirstNameContains(customerFilter.getFamilyFirstName()))
                .and(customerFilter.getIncomeMin() == null ? null : CustomersSpecifications.incomeRange(customerFilter.getIncomeMin(),customerFilter.getIncomeMax()))
                .and(typeOfClient == null ? null : CustomersSpecifications.tipeOfClientContains(typeOfClient))
                .and(currency == null ? null: CustomersSpecifications.currencyContains(currency));


        return convertListToCustomerOutList(customerRepository.findAll(spec));
    }


    private List<CustomerOut> convertListToCustomerOutList(List<Customers> customersList){
        List<CustomerOut> customerOutList = new ArrayList<>();

        for (Customers customers : customersList) {
            customerOutList.add(convertToCustomerOut(customers));
        }

        return customerOutList;
    }

    private CustomerOut convertToCustomerOut(Customers customers){

        CustomerOut customerOut = new CustomerOut();
        customerOut.setIdCustomer(customers.getId());
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
