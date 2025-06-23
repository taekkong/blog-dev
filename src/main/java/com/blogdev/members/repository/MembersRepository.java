package com.blogdev.members.repository;

import com.blogdev.members.domain.Members;

import java.util.Map;

public interface MembersRepository {
    public void save(String name);
    public Members findById(int id);
    public int count();
}
