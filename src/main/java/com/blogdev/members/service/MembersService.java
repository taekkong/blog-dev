package com.blogdev.members.service;

import com.blogdev.members.domain.Members;
import com.blogdev.members.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembersService {

    private final MembersRepository membersRepository;

    public void join(String name){
        membersRepository.save(name);
    }

    public Members findById(int id){
        return membersRepository.findById(id);
    }
}
