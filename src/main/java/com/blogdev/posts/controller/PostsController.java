package com.blogdev.posts.controller;

import com.blogdev.posts.dto.RqPostsDto;
import com.blogdev.posts.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PostsController {
    @Autowired
    PostsService postsService;

    @GetMapping("/posts/new")
    public String newPosts() {
        return "newPosts";
    }

    @PostMapping("/posts/new")
    public String savePosts(RqPostsDto rqPostsDto){
        postsService.save(rqPostsDto);
        return "index";
    }
}
