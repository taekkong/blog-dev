package com.blogdev.posts.service;

import com.blogdev.members.entity.Members;
import com.blogdev.posts.dto.RqPostsDto;
import com.blogdev.posts.dto.RqPostsListDto;
import com.blogdev.posts.dto.RsPostsDto;
import com.blogdev.posts.entity.Posts;
import com.blogdev.posts.repository.PostsRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    public Posts toEntity(RqPostsDto rqPostsDto){
        String title = rqPostsDto.getTitle();
        String content = rqPostsDto.getContent();
        Members author=new Members("aa","aa");

        Posts posts=new Posts(title,content,author);
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

    @Transactional //더티체킹으로 자동으로 DB에 반영되게 하기위함
    public RsPostsDto modifyPosts(int id,RqPostsDto rqPostsDto){
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Posts not found with id " + id)
        );

        posts.update(rqPostsDto.getTitle(),rqPostsDto.getContent(),LocalDateTime.now());

        return new RsPostsDto(posts);
    }

    public List<RqPostsListDto> getAllPostsTitles(){
        return postsRepository.findAllByOrderByIdDesc().stream()
                .map(post->new RqPostsListDto(post.getId(), post.getTitle()))
                .toList();

    }
}
