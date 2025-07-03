package com.blogdev.posts.repository;

import com.blogdev.posts.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer> {
    List<Posts> findAllByOrderByIdDesc(); //최신글 먼저 정렬
}
