package com.blogdev.members.controller;

import com.blogdev.members.domain.Members;
import com.blogdev.members.repository.MembersRepository;
import com.blogdev.members.repository.MemoryMembersRepository;
import com.blogdev.members.service.MembersService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    @DisplayName("회원 조회")
    void getMembers() throws Exception {
        Members mockMember = new Members(1, "마에다 리쿠");

        when(membersService.findById(1)).thenReturn(mockMember);

        mockMvc.perform(get("/members/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("마에다 리쿠"));
    }
}