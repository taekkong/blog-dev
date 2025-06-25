package com.blogdev.members.repository;

import com.blogdev.members.entity.Members;

import java.util.Optional;

public interface MembersRepository {
    public void save(String memberId,String  password);
    public Optional<Members> findByMemberId(String memberId);
    public int count();
}
