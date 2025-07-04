//package com.blogdev.members.service;
//
//import com.blogdev.members.entity.Members;
//import com.blogdev.members.dto.LoginRequestDto;
//import com.blogdev.members.repository.MembersRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class) //목 객체 초기화
//class MembersServiceTest {
//
//    @Mock
//    MembersRepository membersRepository; //목 객체 선언
//
//    @InjectMocks //목 객체 주입받을 대상 객체 생성
//    MembersService membersService;
//
//    @Test
//    @DisplayName("회원가입")
//    void join(){
//        Members members1 = new Members("aa", "bb");
//
//        when(membersRepository.save(any(Members.class))).thenReturn(members1);
//
//        Members members2 = membersService.join(new LoginRequestDto("aa", "bb"));
//
//        Assertions.assertThat(members2).isEqualTo(members1);
//    }
//
//    @Test
//    @DisplayName("로그인")
//    void login(){
//        Members members1 = new Members("aa", "bb");
//
//        when(membersRepository.findByMemberId(any(String.class))).thenReturn(Optional.of(members1));
//
//        String result=membersService.login(new LoginRequestDto("aa", "bb"));
//
//        Assertions.assertThat(result).isEqualTo("로그인 되었습니다.");
//    }
//
//
//}