package com.crm.siigroup.crmApp.models.converter;

import com.crm.siigroup.crmApp.dto.out.CustomerOut;
import com.crm.siigroup.crmApp.models.entity.*;
import org.springframework.stereotype.Component;

//Convertidor de Entity -> Dto y viceversa de Dto -> Entity.
@Component
public class CustomerOutConverter extends AbstractConverter<Customers, CustomerOut>{

    //Mètodo que recibe un Dto y lo convierte a Entity.
    @Override
    public Customers fromDto(CustomerOut dto) {

        if (dto == null){
            return null;
        }

        Customers entity = new Customers();

        Country country = new Country();
        Nationality nationality = new Nationality();
        Gender gender = new Gender();
        Country mobileNumberCode = new Country();
        Country fixNumberCode = new Country();
        Country addressCountry = new Country();
        Currency currency = new Currency();

        country.setCountryId(dto.getCountryId());
        nationality.setNationalityId(dto.getNationalityId());
        gender.setGenderId(dto.getGenderId());
        mobileNumberCode.setCountryId(dto.getMobileNumberId());
        fixNumberCode.setCountryId(dto.getFixNumberId());
        addressCountry.setCountryId(dto.getAddressCountryId());
        currency.setCurrencyId(dto.getCurrencyId());

        entity.setId(dto.getIdCustomer());
        entity.setPersonalId(dto.getPersonalId());
        entity.setName(dto.getName());
        entity.setFamilyFirstName(dto.getFamilyFirstName());
        entity.setFamilySecondName(dto.getFamilySecondName());
        entity.setBirth(dto.getBirth());
        entity.setCountry(country);
        entity.setNationality(nationality);
        entity.setGender(gender);
        entity.setEmail(dto.getEmail());
        entity.setMobileNumberCode(mobileNumberCode);
        entity.setMobileNumber(dto.getMobileNumber());
        entity.setFixNumberCode(fixNumberCode);
        entity.setFixNumber(dto.getFixNumber());
        entity.setAddressCountry(addressCountry);
        entity.setAddressStreet(dto.getAddressStreet());
        entity.setAddressNumber(dto.getAddressNumber());
        entity.setAddressComune(dto.getAddressComune());
        entity.setAddressPostalCode(dto.getAddressPostalCode());
        entity.setAddressCity(dto.getAddressCity());
        entity.setAddressAditional(dto.getAddressAditional());
        entity.setIncome(dto.getIncome());
        entity.setCurrency(currency);
        entity.setTipeOfClient(dto.getTipeOfClient());

        return entity;
    }

    //Mètodo que recibe un Entity y lo convierte a Dto.
    @Override
    public CustomerOut fromEntity(Customers entity) {

        if (entity == null){
            return null;
        }

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
