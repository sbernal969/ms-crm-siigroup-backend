package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.dto.in.UserIn;
import com.crm.siigroup.crmApp.dto.out.LoginOut;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    LoginOut postLogin(UserIn userIn);
}
