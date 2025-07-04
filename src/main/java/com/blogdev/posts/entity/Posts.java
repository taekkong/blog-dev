package com.blogdev.posts.entity;

import com.blogdev.members.entity.Members;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class) //엔티티에서 감시 이벤트를 감지하도록 등록
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY) //게시글 조회시 작성자 정보(author)은 실제로 사용할 때까지 DB에서 조회하지 않고 대기
    @JoinColumn(name="author_id") //외래키 컬럼 이름을 author_id로 하겠다. (Posts테이블에 author_id(Members의 기본키 참조) 컬럼 생김)
    private Members author;

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime modifyDate;

    public Posts(String title, String content, Members members) {
        this.title = title;
        this.content = content;
        this.author=members;
    }

    public void update(String title,String content,LocalDateTime modifyDate){
        this.title = title;
        this.content = content;
    }
}
