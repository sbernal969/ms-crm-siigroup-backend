package com.crm.siigroup.crmApp.dto.in;

import lombok.Data;

@Data
public class CustomerIn {

    private String rut;
    private String firstName;
    private String familyName;
    private String birth;
    private String country;
    private String nacionality;
    private String gender;
    private String email;
    private String mobileNumber;
    private String fixNumber;
    private String postalAddress;
    private int income;
    private int tipeOfClient;
}
