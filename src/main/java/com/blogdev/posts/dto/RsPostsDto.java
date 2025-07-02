package com.blogdev.posts.dto;

import com.blogdev.posts.entity.Posts;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

public class RsPostsDto {
    public int id;
    public String title;
    public String content;
    public int authorId;
    public LocalDateTime createDate;
    public LocalDateTime modifyDate;

    public RsPostsDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.authorId = posts.getAuthorId();
        this.createDate = posts.getCreateDate();
        this.modifyDate = posts.getModifyDate();
    }
}
