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
    @GetMapping("/posts")
    public String GetPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String CreatePost(
            @ModelAttribute Post postToBeSaved) {
        User user = userDao.getOne(1L);
        postToBeSaved.setUser(user);
        postDao.save(postToBeSaved);
        return "redirect:/posts";
    }


    @GetMapping("/show/{id}")
    public String GetPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "/posts/show";
    }

    @GetMapping("/show/{id}/edit")
    public String EditPost(@PathVariable long id, Model model) {
        //will grab passed id from url
        model.addAttribute("post", postDao.getOne(id));
        return "/posts/edit";
    }


//    TODO: create a method to edit a post
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



//    TODO: create a method to delete a post
    @PostMapping("/delete/{id}")
    public String DeletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }
}

