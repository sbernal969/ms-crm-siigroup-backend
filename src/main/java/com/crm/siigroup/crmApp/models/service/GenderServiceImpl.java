package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.controllers.GenderController;
import com.crm.siigroup.crmApp.dto.out.GenderOut;
import com.crm.siigroup.crmApp.models.entity.Gender;
import com.crm.siigroup.crmApp.repository.GenderRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenderServiceImpl implements GenderService{

    @Autowired
    private GenderRepository genderRepository;

    private static final Logger logger = LoggerFactory.getLogger(GenderController.class.getSimpleName());

    @Override
    public List<GenderOut> getGender() throws Exception {

        GenderOut genderOut = new GenderOut();
        List<GenderOut> genderOutList = new ArrayList<>();
        List<Gender> genderList = new ArrayList<>();

        genderList = genderRepository.findAll();

        try {
            for (Gender genderResponse : genderList) {
                genderOut = new GenderOut();
                genderOut.setId(genderResponse.getGenderId());
                genderOut.setGlosa(genderResponse.getGlosa());
                genderOutList.add(genderOut);
            }
        }catch (Exception ex){
            logger.info(ex.getMessage());
        }

        return genderOutList;
    }
}
