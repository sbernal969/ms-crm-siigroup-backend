package com.crm.siigroup.crmApp.models.service;

import com.crm.siigroup.crmApp.controllers.CustomerController;
import com.crm.siigroup.crmApp.dto.in.UserIn;
import com.crm.siigroup.crmApp.dto.out.LoginOut;
import com.crm.siigroup.crmApp.models.entity.Users;
import com.crm.siigroup.crmApp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class.getSimpleName());

    @Override
    public LoginOut postLogin(UserIn userIn) {

        LoginOut loginOut = new LoginOut();
        Users usersDB = new Users();

        usersDB = userRepository.findByUsername(userIn.getUser());

        if (usersDB == null){
            loginOut.setAccess(false);
            loginOut.setTypeRol(0);
            loginOut.setMessage("Usuario no registrado");
        }else{
            String passwordIn = userIn.getPassword();
            //String passwordIn = "scarleth";
            String passwordMd5 = DigestUtils.md5DigestAsHex(passwordIn.getBytes());

            if(passwordMd5.equals(usersDB.getPassword())){
                loginOut.setAccess(true);
                loginOut.setTypeRol(usersDB.getTypeRol());
                loginOut.setMessage("Credenciales correctas");
                loginOut.setName(usersDB.getName());
                loginOut.setLastname(usersDB.getLastName());
                loginOut.setStatus(usersDB.getStatus());
                loginOut.setUsername(usersDB.getUsername());
                logger.info("Contraseña correcta");
                logger.info("Tipo de rol" + usersDB.getTypeRol());
            }else{
                loginOut.setAccess(false);
                loginOut.setTypeRol(usersDB.getTypeRol());
                loginOut.setMessage("Contraseña incorrecta");
                logger.info("Contraseña incorrecta");
                logger.info("Tipo de rol" + usersDB.getTypeRol());
            }

        }

        return loginOut;
    }
}
