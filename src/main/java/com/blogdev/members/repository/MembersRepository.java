package com.blogdev.members.repository;

import com.blogdev.members.domain.Members;

public interface MembersRepository {
    public void save(String name);
    public String findById(int id);
}
