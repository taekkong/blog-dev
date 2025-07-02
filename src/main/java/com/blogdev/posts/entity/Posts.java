package com.blogdev.posts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private int authorId;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    public Posts(String title, String content, int authorId, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }
}
