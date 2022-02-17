package com.crm.siigroup.crmApp.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerOut {

    @JsonProperty
    private String personalId;
    @JsonProperty
    private String name;
    @JsonProperty
    private String familyFirstName;
    @JsonProperty
    private String familySecondName;
    @JsonProperty
    private String birth;

    @JsonProperty
    private Long countryId;;
    @JsonProperty
    private String countryName;


    @JsonProperty
    private Long nationalityId;
    @JsonProperty
    private String nacionalityName;

    @JsonProperty
    private Long genderId;

    @JsonProperty
    private String genderType;


    @JsonProperty
    private String email;

    @JsonProperty
    private Long mobileNumberId;
    @JsonProperty
    private Long mobileNumber;
    @JsonProperty
    private String mobileNumberCode;

    @JsonProperty
    private Long fixNumberId;
    @JsonProperty
    private Long fixNumber;
    @JsonProperty
    private String fixNumberCode;



    @JsonProperty
    private Long addressCountryId;
    @JsonProperty
    private String addressCountryName;



    @JsonProperty
    private String addressStreet;
    @JsonProperty
    private Long addressNumber;


    //@JsonProperty
    //private Long addressComuneId;
    @JsonProperty
    private String addressComune;




    @JsonProperty
    private Long addressPostalCode;
    @JsonProperty
    private String addressCity;
    @JsonProperty
    private String addressAditional;
    @JsonProperty
    private int income;


    @JsonProperty
    private Long currencyId;
    @JsonProperty
    private String currencyName;


    @JsonProperty
    private int tipeOfClient;

}