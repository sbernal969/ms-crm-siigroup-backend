package com.crm.siigroup.crmApp.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ForgotPasswordIn {

    @JsonProperty
    private String user;

}
