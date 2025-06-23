package com.blogdev.members.service;

import com.blogdev.members.domain.Members;
import com.blogdev.members.repository.MembersRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MembersServiceTest {

    @Autowired
    MembersService membersService;

    @Test
    @DisplayName("회원가입 & 회원조회")
    void joinAndFind(){
        membersService.join("오시온");

        Members member=membersService.findById(1);

        Assertions.assertThat(member.getName()).isEqualTo("오시온");
    }


}