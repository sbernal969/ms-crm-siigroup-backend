package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.controllers.CurrencyController;
import com.crm.siigroup.crmApp.dto.out.CurrencyOut;
import com.crm.siigroup.crmApp.models.entity.Currency;
import com.crm.siigroup.crmApp.models.entity.Customers;
import com.crm.siigroup.crmApp.repository.CurrencyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    private static final Logger logger = LoggerFactory.getLogger(CurrencyController.class.getSimpleName());

    @Override
    public List<CurrencyOut> getCurrency() throws Exception {

        CurrencyOut currencyOut = new CurrencyOut();
        List<CurrencyOut> currencyOutlist = new ArrayList<>();
        List <Currency> currencyList = new ArrayList<>();

        try {

            currencyList = currencyRepository.findAll();

            for (int i=0; i<currencyList.size(); i++){
                currencyOut = new CurrencyOut();
                currencyOut.setId(currencyList.get(i).getId());
                currencyOut.setGlosa(currencyList.get(i).getGlosa());
                currencyOutlist.add(currencyOut);
            }
        }catch (Exception ex){
            logger.info(ex.getMessage());
        }
        return currencyOutlist;
    }
}
