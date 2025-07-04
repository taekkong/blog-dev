package com.blogdev;

import com.blogdev.members.entity.Members;
import com.blogdev.members.repository.MembersRepository;
import com.blogdev.posts.entity.Posts;
import com.blogdev.posts.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final PostsRepository postsRepository;
    private final MembersRepository membersRepository;

    @Override
    public void run(String... args) throws Exception {
        //초기 멤버 저장
        Members members1=new Members("aa","aa");
        membersRepository.save(members1);

        //초기 게시글 저장
        Posts posts1 = new Posts("제목1", "내용1", members1);
        Posts posts2 = new Posts("제목2", "내용2", members1);
        postsRepository.save(posts1);
        postsRepository.save(posts2);
    }
}
