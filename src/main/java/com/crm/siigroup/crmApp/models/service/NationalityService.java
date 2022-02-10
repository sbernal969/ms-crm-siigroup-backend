package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.dto.out.NationalityOut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NationalityService {

    List<NationalityOut> getNationality() throws Exception;
}
