package com.blogdev.posts.service;

import com.blogdev.posts.dto.RqPostsDto;
import com.blogdev.posts.entity.Posts;
import com.blogdev.posts.repository.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostsServiceTest {
    @Mock
    PostsRepository postsRepository;

    @InjectMocks
    PostsService postsService;

    @Test
    @DisplayName("글 저장")
    void save(){
        Posts posts1 = new Posts("제목1", "내용1", 1, LocalDate.now(), LocalDate.now());

        when(postsRepository.save(any(Posts.class))).thenReturn(posts1);
        Posts posts2 = postsService.save(new RqPostsDto("제목1","내용1",1,LocalDate.now(),LocalDate.now()));

        Assertions.assertThat(posts2).isEqualTo(posts1);
    }
}