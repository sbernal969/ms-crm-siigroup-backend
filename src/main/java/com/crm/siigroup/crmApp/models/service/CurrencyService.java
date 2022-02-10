package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.dto.out.CurrencyOut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CurrencyService {

    List<CurrencyOut> getCurrency() throws Exception;
}
