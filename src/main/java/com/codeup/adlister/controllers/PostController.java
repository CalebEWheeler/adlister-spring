package com.codeup.adlister.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts") @ResponseBody
    public String Index() {
        return "posts index page";
    }
    @GetMapping("/posts/{id}") @ResponseBody
    public String IndividualPost(@PathVariable int id) {
        return "view user with id of: " +id+ "'s post";
    }
    @GetMapping("/posts/create") @ResponseBody
    public String GetPostPage() {
        return "view the form for creating a post <form method='post'><button>create</button></form>";
    }
    @PostMapping("/posts/create") @ResponseBody
    public String PostPostPage() {
        return "create a new post";
    }
}
