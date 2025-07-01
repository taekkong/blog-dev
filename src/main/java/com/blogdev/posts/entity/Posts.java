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

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private int authorId;
    private LocalDate createDate;
    private LocalDate modifyDate;

    public Posts(String title, String content, int authorId, LocalDate createDate, LocalDate modifyDate) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }
}
