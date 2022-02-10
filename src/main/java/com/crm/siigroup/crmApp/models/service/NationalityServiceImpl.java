package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.controllers.CurrencyController;
import com.crm.siigroup.crmApp.controllers.NationalityController;
import com.crm.siigroup.crmApp.dto.out.NationalityOut;
import com.crm.siigroup.crmApp.models.entity.Nationality;
import com.crm.siigroup.crmApp.repository.NationalityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NationalityServiceImpl implements NationalityService {

    @Autowired
    private NationalityRepository nationalityRepository;

    private static final Logger logger = LoggerFactory.getLogger(NationalityController.class.getSimpleName());

    @Override
    public List<NationalityOut> getNationality() throws Exception {

        NationalityOut nationalityOut = new NationalityOut();
        List<NationalityOut> nationalityOutList = new ArrayList<>();
        List<Nationality> nationalityList = new ArrayList<>();

        try {
            nationalityList = nationalityRepository.findAll();
            for (Nationality nationalityResponse : nationalityList) {
                nationalityOut = new NationalityOut();
                nationalityOut.setId(nationalityResponse.getId());
                nationalityOut.setGlosa(nationalityResponse.getGlosa());
                nationalityOutList.add(nationalityOut);
            }

        }catch (Exception ex){
            logger.info(ex.getMessage());
        }

        return nationalityOutList;
    }
}
