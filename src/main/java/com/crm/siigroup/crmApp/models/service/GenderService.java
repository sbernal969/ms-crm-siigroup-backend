package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.dto.out.GenderOut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenderService {

    List<GenderOut> getGender() throws Exception;
}
