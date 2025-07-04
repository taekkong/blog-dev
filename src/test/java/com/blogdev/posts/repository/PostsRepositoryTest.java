package com.blogdev.posts.repository;

import com.blogdev.members.entity.Members;
import com.blogdev.members.repository.MembersRepository;
import com.blogdev.posts.entity.Posts;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;
    @Autowired
    MembersRepository membersRepository;

    @Test
    @DisplayName("글 작성후 저장")
    void save(){
        Posts posts1 = new Posts("제목1","내용1",new Members("aa","aa"));

        Posts posts2 = postsRepository.save(posts1);

        assertThat(posts2).isEqualTo(posts1);
    }

    @Test
    @DisplayName("글 쓴 멤버 정보 찾기")
    void getMembers(){
        Members author=membersRepository.save(new Members("aa","aa"));
        postsRepository.save(new Posts("제목1", "내용1",author));

        Members members = postsRepository.findById(1).get().getAuthor();

        assertThat(members.getId()).isEqualTo(1);
        assertThat(members.getMemberId()).isEqualTo("aa");
        assertThat(members.getPassword()).isEqualTo("aa");

    }
}