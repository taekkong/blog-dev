package com.blogdev.members.controller;

import com.blogdev.members.domain.Members;
import com.blogdev.members.dto.LoginRequestDto;
import com.blogdev.members.service.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto
    ) {
        String result = membersService.login(loginRequestDto);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/members/new")
    public String newMembers() {
        return "newMembers";
    }
}
