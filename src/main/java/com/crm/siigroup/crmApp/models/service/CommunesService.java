package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.dto.out.CommunesOut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommunesService {

    List<CommunesOut> getCommunes() throws Exception;

}
