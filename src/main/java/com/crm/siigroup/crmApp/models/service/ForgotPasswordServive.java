package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.dto.in.ForgotPasswordIn;
import com.crm.siigroup.crmApp.dto.in.UserIn;
import com.crm.siigroup.crmApp.dto.out.ForgotPasswordOut;
import org.springframework.stereotype.Service;

@Service
public interface ForgotPasswordServive {

    ForgotPasswordOut postForgotPassword(ForgotPasswordIn forgotPasswordIn) throws Exception;

}
