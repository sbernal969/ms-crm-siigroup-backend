package com.crm.siigroup.crmApp.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class CustomerIn {

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
    private Long country;

    @JsonProperty
    private Long nationality;

    @JsonProperty
    private Long gender;

    @JsonProperty
    private String email;

    @JsonProperty
    private Long mobileNumber;

    @JsonProperty
    private Long mobileNumberCode;

    @JsonProperty
    private Long fixNumber;

    @JsonProperty
    private Long fixNumberCode;

    @JsonProperty
    private Long addressCountry;

    @JsonProperty
    private String addressStreet;

    @JsonProperty
    private Long addressNumber;

   /*@JsonProperty
    private Communes addressComune;*/

    @JsonProperty
    private String addressComune;

    @JsonProperty
    private Long addressPostalCode;

    @JsonProperty
    private String addressCity;

    @JsonProperty
    private String addressAditional;

    @JsonProperty
    private Long income;

    @JsonProperty
    private Long currency;

    @JsonProperty
    private int tipeOfClient;
}
