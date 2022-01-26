package com.crm.siigroup.crmApp.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserIn {

    @JsonProperty
    private String user;

    @JsonProperty
    private String password;

}
