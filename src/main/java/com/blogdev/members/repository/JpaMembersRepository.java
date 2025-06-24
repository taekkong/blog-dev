package com.blogdev.members.repository;

import com.blogdev.members.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMembersRepository extends JpaRepository<Members,Long> {
}
