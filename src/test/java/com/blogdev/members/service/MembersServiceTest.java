package com.blogdev.members.service;

import com.blogdev.members.domain.Members;
import com.blogdev.members.dto.LoginRequestDto;
import com.blogdev.members.repository.JpaMembersRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) //목 객체 초기화
class MembersServiceTest {

    @Mock
    JpaMembersRepository jpaMembersRepository; //목 객체 선언

    @InjectMocks //목 객체 주입받을 대상 객체 생성
    MembersService membersService;

    @Test
    @DisplayName("회원가입")
    void join(){
        //given
        Members members1 = new Members("aa", "bb");

        when(jpaMembersRepository.save(any(Members.class))).thenReturn(members1);

        Members members2 = membersService.join(new LoginRequestDto("aa", "bb"));

        Assertions.assertThat(members2).isEqualTo(members1);
    }


}