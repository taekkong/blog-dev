package com.blogdev.members.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    private String memberId;
    private String password;

    public LoginRequestDto(String memberId, String password) {
        this.memberId=memberId;
        this.password=password;
    }
}
