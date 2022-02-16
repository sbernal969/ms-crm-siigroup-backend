package com.crm.siigroup.crmApp.dto.in;

import com.crm.siigroup.crmApp.models.entity.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerIn {

    @JsonProperty
    private String rut;

    @JsonProperty
    private String name;

    @JsonProperty
    private String familyFirstName;

    @JsonProperty
    private String familySecondName;

    @JsonProperty
    private Date birth;

    @JsonProperty
    private Country country;

    @JsonProperty
    private Nationality nationality;

    @JsonProperty
    private Gender gender;

    @JsonProperty
    private String email;

    @JsonProperty
    private Long mobileNumber;

    @JsonProperty
    private Country mobileNumberCode;

    @JsonProperty
    private Long fixNumber;

    @JsonProperty
    private Country fixNumberCode;

    @JsonProperty
    private Country addressCountry;

    @JsonProperty
    private String addressStreet;

    @JsonProperty
    private Long addressNumber;

    @JsonProperty
    private Communes addressComune;

    @JsonProperty
    private Long addressPostalCode;

    @JsonProperty
    private String addressCity;

    @JsonProperty
    private String addressAditional;

    @JsonProperty
    private int income;

    @JsonProperty
    private Currency currency;

    @JsonProperty
    private int tipeOfClient;
}
