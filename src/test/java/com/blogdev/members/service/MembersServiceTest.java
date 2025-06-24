package com.blogdev.members.service;

import com.blogdev.members.domain.Members;
import com.blogdev.members.dto.LoginRequestDto;
import com.blogdev.members.repository.MembersRepository;
import com.blogdev.members.repository.MemoryMembersRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MembersServiceTest {

    MembersRepository membersRepository=new MemoryMembersRepository();
    MembersService membersService=new MembersService(membersRepository);

    @Test
    @DisplayName("회원가입 & 회원조회")
    void joinAndFind(){
        LoginRequestDto longinRequestDto = new LoginRequestDto("aa", "bb");
        membersService.join(longinRequestDto);

        String result = membersService.login(new LoginRequestDto("aa","bb"));

        Assertions.assertThat(result).isEqualTo("로그인 되었습니다.");
    }


}