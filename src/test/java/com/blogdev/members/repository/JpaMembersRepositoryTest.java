package com.blogdev.members.repository;

import com.blogdev.members.entity.Members;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("h2")
public class JpaMembersRepositoryTest {
    @Autowired
    MembersRepository membersRepository;

    @Test
    @DisplayName("회원 저장")
    void save() {
        Members members1 = new Members("aa","bb");

        membersRepository.save(members1);
        assertThat(members1.getId()).isEqualTo(1);
    }
//
//    @Test
//    @DisplayName("로그인")
//    void login(){
//        Members members1 = new Members("aa","bb");
//        membersRepository.save(members1);
//
//        Optional<Members> members2=membersRepository.findById(1);
//
//        assertThat(members2).hasValue(members1);
//    }

}
