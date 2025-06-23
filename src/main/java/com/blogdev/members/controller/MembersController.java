package com.blogdev.members.controller;

import com.blogdev.members.domain.Members;
import com.blogdev.members.service.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MembersController {

    private final MembersService membersService;

    @GetMapping("/members")
    public String members(){
        return "members";
    }

    @GetMapping("/members/{id}")
    @ResponseBody
    public String getMembers(@PathVariable int id){
        Members member = membersService.findById(id);
        return member.getName();
    }

    @PostMapping("/members")
    public String addMembers(@RequestParam String name) {
        membersService.join(name);

        return "redirect:/index.html";
    }
}
