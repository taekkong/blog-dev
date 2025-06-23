package com.blogdev.members.controller;

import com.blogdev.members.domain.Members;
import com.blogdev.members.dto.LoginRequestDto;
import com.blogdev.members.service.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MembersController {

    private final MembersService membersService;

    @GetMapping("/members")
    public String members() {
        return "login";
    }

    @PostMapping("/members")
    public String login(@RequestBody LoginRequestDto loginRequestDto
    ) {
        String memberId=loginRequestDto.getMemberId();
        String password=loginRequestDto.getPassword();

        membersService.login(memberId,password);

        return "index";
    }
}
