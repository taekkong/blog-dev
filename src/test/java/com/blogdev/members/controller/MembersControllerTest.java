package com.blogdev.members.controller;

import com.blogdev.TestConfig;
import com.blogdev.members.dto.LoginRequestDto;

import com.blogdev.members.entity.Members;
import com.blogdev.members.service.MembersService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MembersController.class)
@Import(TestConfig.class)
class MembersControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MembersService membersService;

    @Test
    @DisplayName("회원가입")
    void join() throws Exception{
        String requestBody = """
                {
                    "memberId":"aa",
                    "password":"bb"
                }
                """;

        when(membersService.join(any(LoginRequestDto.class))).thenReturn(new Members("aa", "bb"));

        mockMvc.perform(post("/members/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

    }
    @Test
    @DisplayName("로그인")
    void login() throws Exception {
        //given
        String requestBody = """
                {
                    "memberId":"Nct Wish",
                    "password":"Riku"
                }
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

}