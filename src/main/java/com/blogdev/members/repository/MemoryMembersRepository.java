package com.blogdev.members.repository;

import com.blogdev.members.domain.Members;

import java.util.HashMap;
import java.util.Map;

public class MemoryMembersRepository implements MembersRepository {
    private Map<Integer, Members> members = new HashMap<>();
    private int lastId = 0;

    @Override
    public void save(String name) {
        Members member = new Members(++lastId, name);
        members.put(member.getId(), member);
    }

    @Override
    public String findById(int id){
        return members.get(id).getName();
    }
}
