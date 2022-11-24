package com.in28minutes.springboot.myfirstwebapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public String login(@RequestParam("name") String name, ModelMap modelMap) {
        modelMap.put("name", name);
        LOGGER.info("Request Param is: "+ name);
        return "login";
    }
}
