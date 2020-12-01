package com.codeup.adlister.controllers;

import com.codeup.adlister.Repository.PostRepository;
import com.codeup.adlister.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }
    //    @GetMapping("/posts/create") @ResponseBody
//    public String GetPostPage() {
//        return "view the form for creating a post <form method='post'><button>create</button></form>";
//    }
//    @PostMapping("/posts/create") @ResponseBody
//    public String PostPostPage() {
//        return "create a new post";
//    }
    @GetMapping("/posts")
    public String GetPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }

    @GetMapping("/show/{n}")
    public String GetPost(@PathVariable String n, Model model) {
        Long id = Long.parseLong(n);
        model.addAttribute("post", postDao.getOne(id));
        return "/posts/show";
    }
//    TODO: create a method to edit a post

    @PostMapping("/show/{n}")
    public String UpdatePost(
            @PathVariable long n,
            @RequestParam(name="editTitle") String title,
            @RequestParam(name="editBody") String body) {
        Post post = new Post(n, title, body);
        postDao.save(post);
        return "redirect:/show/"+post.getId();
    }

//    TODO: create a method to delete a post
}

