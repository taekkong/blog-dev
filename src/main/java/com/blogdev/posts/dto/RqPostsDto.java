package com.blogdev.posts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class RqPostsDto {
    String title;
    String content;
}
