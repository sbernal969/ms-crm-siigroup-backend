package com.crm.siigroup.crmApp.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {
    int codigo;
    String mensaje;
    T data;
}