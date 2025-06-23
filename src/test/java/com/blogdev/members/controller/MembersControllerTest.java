package com.blogdev.members.controller;

import com.blogdev.members.dto.LoginRequestDto;

import com.blogdev.members.service.MembersService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MembersController.class)
@AutoConfigureMockMvc
class MembersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MembersService membersService; //서비스 빈을 가짜(Mock)로 만듦 (테스트용으로만 동작하는 객체)
    //진자로직 수행 x (직접 when().thenReturn()으로 행동 지정)

    @Test
    @DisplayName("로그인")
    void login() throws Exception {
        //given
        String requestBody = """
                {"memberId":"Nct Wish",
                "password":"Riku"}
                """;

        when(membersService.login(any(LoginRequestDto.class)))
                .thenReturn("로그인 되었습니다.");
        //when&then
        mockMvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("로그인 되었습니다."));
    }

    @Test
    @DisplayName("회원가입")
    void singIn() throws Exception {
        //given
        String
    }
}