package com.blogdev.posts.dto;

import com.blogdev.members.entity.Members;
import com.blogdev.posts.entity.Posts;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RsPostsDto {
    public Long id;
    public String title;
    public String content;
    public Members author;
    public LocalDateTime createDate;
    public LocalDateTime modifyDate;

    public RsPostsDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.author = posts.getAuthor();
        this.createDate = posts.getCreateDate();
        this.modifyDate = posts.getModifyDate();
    }
}
