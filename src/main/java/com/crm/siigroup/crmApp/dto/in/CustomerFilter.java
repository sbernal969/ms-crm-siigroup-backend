package com.crm.siigroup.crmApp.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerFilter {

    @JsonProperty
    private String personalId;
    @JsonProperty
    private String name;
    @JsonProperty
    private String familyFirstName;
    @JsonProperty
    private Long incomeMax;
    @JsonProperty
    private Long incomeMin;
    @JsonProperty
    private Long idCurrency;
    @JsonProperty
    private boolean isCustomer;
    @JsonProperty
    private boolean isProspect;
}
