package com.codeup.adlister.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeControllerClass {
    @GetMapping("/")
    @ResponseBody
    public String Message() {
        return "This is the landing page!";
    }
}
