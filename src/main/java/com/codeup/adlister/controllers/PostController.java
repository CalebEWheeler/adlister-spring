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
    //Show's all posts
    @GetMapping("/posts")
    public String GetPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }


    //Post creation get and post requests
    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    //TODO: WILL NEED TO PASS A LOGGED IN USER ID WHEN WE GET THERE AND HAVE IT
    // PASSED IN THE POST METHOD TO CONNECT THE "POST" TO THE LOGGED IN "USER"
    @PostMapping("/posts/create")
    public String CreatePost(
            @ModelAttribute Post postToBeSaved) {
        User user = userDao.getOne(1L);
        postToBeSaved.setUser(user);
        postDao.save(postToBeSaved);
        return "redirect:/posts";
    }


    //Show's a single post's content
    @GetMapping("/show/{id}")
    public String GetPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "/posts/show";
    }


    //Post edit get and post requests
    @GetMapping("/show/{id}/edit")
    public String EditPost(@PathVariable long id, Model model) {
        //will grab passed id from url
        model.addAttribute("post", postDao.getOne(id));
        return "/posts/edit";
    }
    @PostMapping("/show/{id}/edit")
    public String UpdatePost(
            @PathVariable long id,
            @ModelAttribute Post postToBeEdited
            ){
        User user = postDao.getOne(id).getUser();
        postToBeEdited.setUser(user);
        postToBeEdited.setId(id);
        postDao.save(postToBeEdited);
        return "redirect:/posts";
    }


    //Delete's a post by it's passed Id
    @PostMapping("/delete/post/{id}")
    public String DeletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }
}

