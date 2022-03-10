package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void getCustomer() throws Exception {
        /*CustomerOut customerOut = CustomerOut.builder()
                .idCustomer(1L)
                .personalId("259994684")
                .name("Franklin")
                .familyFirstName("Conde")
                .familySecondName("Gonzalez")
                .birth("13-03-1991")
                .countryId(40L)
                .countryName("Chile")
                .nationalityId(218L)
                .nacionalityName("Venezuelan")
                .genderId(2L)
                .genderType("Male")
                .email("franklinpqn@gmail.com")
                .mobileNumberId(242L)
                .mobileNumber(955370058L)
                .mobileNumberCode("58")
                .fixNumberId(242L)
                .fixNumber(65465465L)
                .fixNumberCode("58")
                .addressCountryId(40L)
                .addressCountryName("Chile")
                .addressStreet("Las cañas")
                .addressNumber(6087L)
                .addressComune("Las condes")
                .addressPostalCode(null)
                .addressCity("Santiago")
                .addressAditional("Info adicional")
                .income(150000000L)
                .currencyId(3L)
                .currencyName("CLP")
                .tipeOfClient(0)
                .build();
        customerRepository.findAll((Pageable) customerOut);*/

        //List<CustomerOut> customersList = customerRepository.findAll(1L);
    }
}