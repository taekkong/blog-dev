package com.blogdev.posts.repository;

import com.blogdev.posts.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Integer> {
}
