package com.in28minutes.springboot.myfirstwebapp.controller;

import com.in28minutes.springboot.myfirstwebapp.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {
    private Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/login")
    public String goToLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String goToWelcome(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
        modelMap.put("name", name);
        if(authenticationService.checkUserName(name) && authenticationService.checkPassword(password))
            return "welcome";
        modelMap.put("errorMessage","Username or password is incorrect. Please try again.");
        return "login";
    }
}
