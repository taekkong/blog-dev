package com.blogdev.posts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostsController {

    @GetMapping("/posts/new")
    public String newPost() {
        return "newPosts";
    }
}
