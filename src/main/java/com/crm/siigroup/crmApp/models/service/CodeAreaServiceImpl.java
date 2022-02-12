package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.controllers.CodeAreaController;
import com.crm.siigroup.crmApp.dto.out.CodeAreaOut;
import com.crm.siigroup.crmApp.models.entity.CodeArea;
import com.crm.siigroup.crmApp.repository.CodeAreaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodeAreaServiceImpl implements CodeAreaService{

    @Autowired
    private CodeAreaRepository codeAreaRepository;

    private static final Logger logger = LoggerFactory.getLogger(CodeAreaController.class.getSimpleName());

    @Override
    public List<CodeAreaOut> getCodeArea() throws Exception {

        CodeAreaOut codeAreaOut = new CodeAreaOut();
        List<CodeArea> codeAreaList = new ArrayList<>();
        List<CodeAreaOut> codeAreaOutList = new ArrayList<>();

        codeAreaList = codeAreaRepository.findAll();

        try {
            for (CodeArea codeAreaResponse : codeAreaList) {
                codeAreaOut = new CodeAreaOut();
                codeAreaOut.setId(codeAreaResponse.getId());
                codeAreaOut.setPhone_code(codeAreaResponse.getPhone_code());
                codeAreaOutList.add(codeAreaOut);
            }
        }catch (Exception ex){
            logger.info(ex.getMessage());
        }


        return codeAreaOutList;
    }
}
