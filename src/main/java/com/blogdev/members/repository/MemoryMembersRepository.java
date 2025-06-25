package com.blogdev.members.repository;

import com.blogdev.members.entity.Members;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryMembersRepository implements MembersRepository {
    private Map<Integer, Members> members = new HashMap<>();
    private int lastId = 0;

    @Override
    public void save(String memberId,String password) {
        Members member = new Members(++lastId, memberId, password);
        members.put(member.getId(), member);
        System.out.println("success Members save");
    }

    @Override
    public Optional<Members> findByMemberId(String memberId){
        for(Members m :members.values()){
            if(m.getMemberId().equals(memberId)){
                return Optional.of(m);
            }
        }
        return Optional.empty();
    }

    @Override
    public int count() {
        return members.size();
    }

}
