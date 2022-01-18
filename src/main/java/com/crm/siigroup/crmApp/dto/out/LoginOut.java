package com.crm.siigroup.crmApp.dto.out;

import lombok.Data;

@Data
public class LoginOut {

    private Boolean access;
    private int typeRol;
    private String name;
    private String lastname;
    private Boolean status;
    private String username;
    private String message;
}
