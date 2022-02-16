package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.controllers.CommunesController;
import com.crm.siigroup.crmApp.dto.out.CommunesOut;
import com.crm.siigroup.crmApp.models.entity.Communes;
import com.crm.siigroup.crmApp.repository.CommunesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommunesServiceImpl implements CommunesService{

    @Autowired
    private CommunesRepository communesRepository;

    private static final Logger logger = LoggerFactory.getLogger(CommunesController.class.getSimpleName());

    @Override
    public List<CommunesOut> getCommunes() throws Exception {

        CommunesOut communesOut = new CommunesOut();
        List<CommunesOut> communesOutList = new ArrayList<>();
        List<Communes> communesList = new ArrayList<>();

        communesList = communesRepository.findAll();

        try {
            for (Communes communesResponse : communesList) {
                communesOut = new CommunesOut();
                communesOut.setId(communesResponse.getCommunesId());
                communesOut.setGlosa(communesResponse.getGlosa());
                communesOutList.add(communesOut);
            }
        }catch (Exception ex){
            logger.info(ex.getMessage());
        }
        return communesOutList;
    }
}
