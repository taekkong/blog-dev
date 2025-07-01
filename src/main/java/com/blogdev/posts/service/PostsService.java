package com.blogdev.posts.service;

import com.blogdev.members.dto.LoginRequestDto;
import com.blogdev.posts.dto.RqPostsDto;
import com.blogdev.posts.entity.Posts;
import com.blogdev.posts.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    public Posts toEntity(RqPostsDto rqPostsDto){
        String title = rqPostsDto.getTitle();
        String content=rqPostsDto.getContent();
        int authorId=1;
        LocalDate createDate=LocalDate.now();
        LocalDate modifyDate=LocalDate.now();

        Posts posts=new Posts(title,content,authorId,createDate,modifyDate);
        return posts;
    }

    public Posts save(RqPostsDto rqPostsDto){
        Posts posts = toEntity(rqPostsDto);

        return postsRepository.save(posts);
    }
}
