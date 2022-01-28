package com.crm.siigroup.crmApp.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerIn {

    @JsonProperty
    private String rut;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String familyName;
    @JsonProperty
    private String birth;
    @JsonProperty
    private String country;
    @JsonProperty
    private String nacionality;
    @JsonProperty
    private String gender;
    @JsonProperty
    private String email;
    @JsonProperty
    private String mobileNumber;
    @JsonProperty
    private String fixNumber;
    @JsonProperty
    private String postalAddress;
    @JsonProperty
    private int income;
    @JsonProperty
    private int tipeOfClient;
}
