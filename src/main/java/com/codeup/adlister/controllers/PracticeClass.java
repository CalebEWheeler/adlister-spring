package com.codeup.adlister.controllers;
//TODO define controller: will need to import class below
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PracticeClass {
//    TODO define RequestMapping (url extension) !!WILL THROW AN ERROR IF A RESPONSEBODY IS VOID!!
    @GetMapping("/practice")

    //TODO define the ResponseBody (output of RequestMapping)
    @ResponseBody
    public String practiceMessage() {
        return "Practicing Controller Setup!";
    }


}
