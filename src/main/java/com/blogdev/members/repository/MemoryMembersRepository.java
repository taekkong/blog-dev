package com.blogdev.members.repository;

import com.blogdev.members.domain.Members;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryMembersRepository implements MembersRepository {
    private Map<Integer, Members> members = new HashMap<>();
    private int lastId = 0;

    @Override
    public void save(String name) {
        Members member = new Members(++lastId, name);
        members.put(member.getId(), member);
    }

    @Override
    public Members findById(int id){
        return members.get(id);
    }

    @Override
    public int count() {
        return members.size();
    }
}
