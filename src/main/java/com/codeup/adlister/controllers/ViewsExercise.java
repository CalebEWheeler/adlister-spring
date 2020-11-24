package com.codeup.adlister.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewsExercise {
    @GetMapping("/roll-dice")
    public String startGuessGame() {
        return "/roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String testGuess(@PathVariable String n, Model model) {
        String random = Integer.toString(randomRange(1,6));

        model.addAttribute("random", random);
        model.addAttribute("n", n);
        return "/die-result";
    }

    int randomRange(int min, int max) {
        int range = (max-min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
