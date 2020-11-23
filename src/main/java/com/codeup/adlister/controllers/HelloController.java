package com.codeup.adlister.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello") //request
    @ResponseBody // response
    public String showAHelloMessage() {
        return "Hello from Spring!"; // what I respond with
    }

    @GetMapping("/create-a-hello")
    @ResponseBody
    public String showCreatePage(){
        return "this would be the create form";
    }

    @PostMapping("/hello")
    @ResponseBody
    public String submitCreateForm(){
        //... saving an ad
        return "ad has been saved!";
    }

}