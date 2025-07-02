package com.blogdev.posts.service;

import com.blogdev.members.dto.LoginRequestDto;
import com.blogdev.posts.dto.RqPostsDto;
import com.blogdev.posts.dto.RsPostsDto;
import com.blogdev.posts.entity.Posts;
import com.blogdev.posts.repository.PostsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    public Posts toEntity(RqPostsDto rqPostsDto){
        String title = rqPostsDto.getTitle();
        String content=rqPostsDto.getContent();
        int authorId=1;
        LocalDateTime createDate=LocalDateTime.now();
        LocalDateTime modifyDate=LocalDateTime.now();

        Posts posts=new Posts(title,content,authorId,createDate,modifyDate);
        return posts;
    }

    public Posts save(RqPostsDto rqPostsDto){
        Posts posts = toEntity(rqPostsDto);

        return postsRepository.save(posts);
    }

    public RsPostsDto getPosts(int id){
        Posts posts = postsRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Posts not found with id " + id)
        );

        return new RsPostsDto(posts);
    }

    public List<RsPostsDto> getAllPosts(){
        return postsRepository.findAll()
                .stream()
                .map(RsPostsDto::new)
                .collect(Collectors.toList());
    }

    public void deletePosts(int id){
        postsRepository.deleteById(id);
    }
}
