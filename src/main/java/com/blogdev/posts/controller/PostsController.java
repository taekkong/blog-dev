package com.blogdev.posts.controller;

import com.blogdev.posts.dto.RqPostsDto;
import com.blogdev.posts.dto.RqPostsListDto;
import com.blogdev.posts.dto.RsPostsDto;
import com.blogdev.posts.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostsController {
    @Autowired
    PostsService postsService;

    //홈 화면
    @GetMapping("/")
    public String getPostsTitles(Model model) {
        List<RqPostsListDto> posts=postsService.getAllPostsTitles();

        model.addAttribute("posts",posts);
        return "index";
    }

    //글 작성 폼
    @GetMapping("/posts/new")
    public String newPosts() {
        return "newPosts";
    }

    //글 작성
    @PostMapping("/posts/new")
    public String savePosts(RqPostsDto rqPostsDto){
        postsService.save(rqPostsDto);
        return "redirect:/";
    }


    /*@GetMapping("/posts/{id}")
    @ResponseBody
    public RsPostsDto getPosts(@PathVariable int id){
        return postsService.getPosts(id);
    }*/

    @GetMapping("/posts/{id}")
    public String getPosts(@PathVariable int id, Model model) {
        RsPostsDto rsPostsDto = postsService.getPosts(id);

        model.addAttribute("posts",rsPostsDto);
        return "getPosts";
    }

    @GetMapping("/posts/delete/{id}")
    public String deletePosts(@PathVariable int id){
        postsService.deletePosts(id);

        return "redirect:/";
    }

    @GetMapping("/posts/modify/{id}")
    public String modifyPostsById(@PathVariable int id, Model model) {
        RsPostsDto rsPostsDto = postsService.getPosts(id);

        model.addAttribute("posts",rsPostsDto);
        return "modifyPosts";
    }

    @PostMapping("/posts/modify/{id}")
    public String modifyPosts(@PathVariable int id,RqPostsDto rqPostsDto){
        postsService.modifyPosts(id,rqPostsDto);

        return "redirect:/";
    }
}
