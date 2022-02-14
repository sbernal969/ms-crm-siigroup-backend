package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.dto.out.CodeAreaOut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CodeAreaService {

    List<CodeAreaOut> getCodeArea() throws Exception;
}
