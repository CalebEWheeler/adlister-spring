package com.codeup.adlister.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
//    @GetMapping("/posts") @ResponseBody
//    public String Index() {
//        return "posts index page";
//    }
//
//    @GetMapping("/posts/{id}") @ResponseBody
//    public String IndividualPost(@PathVariable long id) {
//        return "view user with id of: " +id+ "'s post";
//    }
//
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
        posts();
        model.addAttribute("posts", posts());
        return "/posts/index";
    }

    @GetMapping("/posts/show")
    public String GetPost(Model model) {
        Post post = new Post("1984 Schwinn Bike", "Stored in a storage unit since 1990 and kept covered to help prevent environmental exposure. In very good condition");
        model.addAttribute("post", post);

        //has to stay this way so there is a path to show.html...
        return "posts/show";
    }

    public List<Post> posts() {
        List<Post> postList = new ArrayList<>();
        Post post1 = new Post("Fleece Sweater", "Like new Eddie Bauer fleece sweater, worn once.");
        Post post2 = new Post("Sharpie Marker's 24ct", "Unopened box of large tip sharpie markers");
        Post post3 = new Post("Personal Vaporizer", "VooPoo Drag 2 Platinum for sale. Comes with 3 extra FireLuke Max 10ohm coils");

//        Post post1 = new Post(1,"Fleece Sweater", "Like new Eddie Bauer fleece sweater, worn once.");
//        Post post2 = new Post(2,"Sharpie Marker's 24ct", "Unopened box of large tip sharpie markers");
//        Post post3 = new Post(3,"Personal Vaporizer", "VooPoo Drag 2 Platinum for sale. Comes with 3 extra FireLuke Max 10ohm coils");

        postList.add(post1);
        postList.add(post2);
        postList.add(post3);
        return postList;
    }

}

