package com.crm.siigroup.crmApp.dto.out;

import lombok.Data;

@Data
public class CustomerCreatedOut {

    private Boolean customerCreated;
    private String message;
    private Long idCustomer;

}
