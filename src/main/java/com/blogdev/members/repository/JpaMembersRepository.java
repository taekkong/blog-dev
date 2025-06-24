package com.blogdev.members.repository;

import com.blogdev.members.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaMembersRepository extends JpaRepository<Members,Long> {
    Optional<Members> findByMemberId(String memberId);
}
