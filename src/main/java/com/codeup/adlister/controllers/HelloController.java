package com.codeup.adlister.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "/hello";
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

    @GetMapping("/get-zip/{zipcode}")
    @ResponseBody
    public int getZipCode(@PathVariable int zipcode){
        return zipcode;
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }


    @GetMapping("/join")
    public String showJoinForm(Model model) {
        List<String> cohortNames = new ArrayList<>();
        cohortNames.add("COBOL");
        cohortNames.add("Draco");
        cohortNames.add("Bash");
        cohortNames.add("IO");
        cohortNames.add("Bash");

        model.addAttribute("cohortNames", cohortNames);
        return "/join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " +cohort+"!");
        return "/join";
    }
}