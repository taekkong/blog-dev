package com.blogdev.members.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Members {
    private final int id;
    private final String memberId;
    private final String password;
}
