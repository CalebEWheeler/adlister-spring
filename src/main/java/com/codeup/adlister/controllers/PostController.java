package com.codeup.adlister.controllers;

import com.codeup.adlister.Repository.PostRepository;
import com.codeup.adlister.Repository.UserRepository;
import com.codeup.adlister.models.Post;
import com.codeup.adlister.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }
        @GetMapping("/posts/create") @ResponseBody
    public String ShowCreateForm() {
        return "posts/new";
    }
    @PostMapping("/posts/create") @ResponseBody
    public String CreatePost(
            @RequestParam(name="title") String title,
            @RequestParam(name="body") String body
    ) {
        User user = userDao.getOne(1L);
        Post post = new Post(title, body, user);
        Post dbPost = postDao.save(post);
        return "redirect:/posts/" + dbPost.getId();
    }
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
        Post dbPost = postDao.getOne(n);
        dbPost.setTitle(title);
        dbPost.setBody(body);
        postDao.save(dbPost);
        return "redirect:/show/"+dbPost.getId();
    }

//    TODO: create a method to delete a post
    @PostMapping("/delete/{id}")
    public String DeletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }
}

