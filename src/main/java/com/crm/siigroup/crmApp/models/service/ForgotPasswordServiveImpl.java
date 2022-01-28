package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.controllers.ForgotPasswordController;
import com.crm.siigroup.crmApp.dto.in.ForgotPasswordIn;
import com.crm.siigroup.crmApp.dto.out.ForgotPasswordOut;
import com.crm.siigroup.crmApp.models.entity.Users;
import com.crm.siigroup.crmApp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordServiveImpl implements ForgotPasswordServive{

    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(ForgotPasswordController.class.getSimpleName());

    @Override
    public ForgotPasswordOut postForgotPassword(ForgotPasswordIn forgotPasswordIn) throws Exception {

        Users usersDB = userRepository.findByUsername(forgotPasswordIn.getUser());
        ForgotPasswordOut forgotPasswordOut = new ForgotPasswordOut();

        if (usersDB == null || usersDB.equals("")  || !(forgotPasswordIn.getUser().equals(usersDB.getUsername()))){
            forgotPasswordOut.setMessage("Usuario no registrado");
        }else{
            forgotPasswordOut.setEmail(usersDB.getEmail());
            forgotPasswordOut.setMessage("Correo enviado a " + usersDB.getEmail());
        }

        return forgotPasswordOut;

    }

}
