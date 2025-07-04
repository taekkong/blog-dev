package com.blogdev.posts.repository;

import com.blogdev.members.entity.Members;
import com.blogdev.posts.entity.Posts;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("h2")
class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @Test
    @DisplayName("글 작성후 저장")
    void save(){
        Posts posts1 = new Posts("제목1","내용1",new Members("aa","aa"));

        Posts posts2 = postsRepository.save(posts1);

        assertThat(posts2).isEqualTo(posts1);
    }
}