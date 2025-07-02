package com.blogdev.posts.controller;

import com.blogdev.posts.dto.RqPostsDto;
import com.blogdev.posts.dto.RsPostsDto;
import com.blogdev.posts.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @GetMapping("/posts")
//    public ResponseEntity<List<RsPostsDto>> getAllPosts() {
//        return ResponseEntity.ok(postsService.getAllPosts());
//    }

    @GetMapping("/posts")
    @ResponseBody
    public List<RsPostsDto> getAllPosts() {
        return postsService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public RsPostsDto getPosts(@PathVariable int id){
        return postsService.getPosts(id);
    }

    @GetMapping("/posts/delete/{id}")
    public String deletePosts(@PathVariable int id){
        postsService.deletePosts(id);

        return "index";
    }
}
