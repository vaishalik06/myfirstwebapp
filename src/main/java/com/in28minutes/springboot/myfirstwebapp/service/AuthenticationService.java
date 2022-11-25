package com.in28minutes.springboot.myfirstwebapp.service;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    public boolean checkUserName(String name){
        if(name.equalsIgnoreCase("Vaishali"))
            return true;
        return false;
    }

    public boolean checkPassword(String password){
        if(password.equalsIgnoreCase("password"))
            return true;
        return false;
    }
}
