package com.crm.siigroup.crmApp.models.converter;

import com.crm.siigroup.crmApp.dto.out.CustomerOut;
import com.crm.siigroup.crmApp.models.entity.*;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter extends AbstractConverter<Customers, CustomerOut>{

    @Override
    public CustomerOut fromEntity(Customers entity) {

        CustomerOut customerOut = new CustomerOut();

        customerOut.setIdCustomer(entity.getId());
        customerOut.setPersonalId(entity.getPersonalId());
        customerOut.setName(entity.getName());
        customerOut.setFamilyFirstName(entity.getFamilyFirstName());
        customerOut.setFamilySecondName(entity.getFamilySecondName());
        customerOut.setBirth(entity.getBirth());
        customerOut.setCountryId(entity.getCountry().getCountryId());
        customerOut.setCountryName(entity.getCountry().getName());
        customerOut.setNationalityId(entity.getNationality().getNationalityId());
        customerOut.setNacionalityName(entity.getNationality().getGlosa());
        customerOut.setGenderId(entity.getGender().getGenderId());
        customerOut.setGenderType(entity.getGender().getGlosa());
        customerOut.setEmail(entity.getEmail());
        customerOut.setMobileNumberId(entity.getMobileNumberCode().getCountryId());
        customerOut.setMobileNumber(entity.getMobileNumber());
        customerOut.setMobileNumberCode(entity.getMobileNumberCode().getCode());
        customerOut.setFixNumberId(entity.getFixNumberCode().getCountryId());
        customerOut.setFixNumber(entity.getFixNumber());
        customerOut.setFixNumberCode(entity.getFixNumberCode().getCode());
        customerOut.setAddressCountryId(entity.getAddressCountry().getCountryId());
        customerOut.setAddressCountryName(entity.getAddressCountry().getName());
        customerOut.setAddressStreet(entity.getAddressStreet());
        customerOut.setAddressNumber(entity.getAddressNumber());
        customerOut.setAddressComune(entity.getAddressComune());
        customerOut.setAddressPostalCode(entity.getAddressPostalCode());
        customerOut.setAddressCity(entity.getAddressCity());
        customerOut.setAddressAditional(entity.getAddressAditional());
        customerOut.setIncome(entity.getIncome());
        customerOut.setCurrencyId(entity.getCurrency().getCurrencyId());
        customerOut.setCurrencyName(entity.getCurrency().getGlosa());
        customerOut.setTipeOfClient(entity.getTipeOfClient());

        return customerOut;
    }

}
