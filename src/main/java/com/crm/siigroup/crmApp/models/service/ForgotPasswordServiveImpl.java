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
import org.springframework.util.DigestUtils;

@Service
public class ForgotPasswordServiveImpl extends SendEmailService implements ForgotPasswordServive {

    @Autowired
    private PasswordGeneratorService passwordGeneratorService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SendEmailService sendEmailService;

    private static final Logger logger = LoggerFactory.getLogger(ForgotPasswordController.class.getSimpleName());

    @Override
    public ForgotPasswordOut postForgotPassword(ForgotPasswordIn forgotPasswordIn) throws Exception {

        try{
            Users usersDB = userRepository.findByUsername(forgotPasswordIn.getUser());
            ForgotPasswordOut forgotPasswordOut = new ForgotPasswordOut();

            if (usersDB == null || usersDB.equals("")  || !(forgotPasswordIn.getUser().equals(usersDB.getUsername()))){
                forgotPasswordOut.setMessage("Usuario no registrado");
                logger.info("Registro de usuario");
            }else{
                String newPassword = passwordGeneratorService.getPassword();
                sendEmailService.sendMail(usersDB.getEmail(), "SOLICITUD DE NUENA CLAVE", "Estimado " + usersDB.getName() + " " + usersDB.getLastName() + " su nueva clave es: " + newPassword);
                String passworMd5Encrip = DigestUtils.md5DigestAsHex(newPassword.getBytes());

                usersDB.setPassword(passworMd5Encrip);
                userRepository.save(usersDB);

                forgotPasswordOut.setEmail(usersDB.getEmail());
                forgotPasswordOut.setMessage("Correo enviado a " + usersDB.getEmail());
                logger.info("Envío de correo");
            }

            return forgotPasswordOut;
        }
        catch (Exception ex){
            ForgotPasswordOut forgotPasswordOut = new ForgotPasswordOut();
            System.out.println(ex.getMessage());
            logger.info("Error interno: " + ex.getMessage());
            forgotPasswordOut.setEmail("");
            forgotPasswordOut.setMessage("Error interno: " + ex.getMessage());
            return forgotPasswordOut;
        }
    }
}
