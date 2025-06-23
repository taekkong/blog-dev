package com.blogdev.members.service;

import com.blogdev.members.domain.Members;
import com.blogdev.members.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MembersService {

    private final MembersRepository membersRepository;

    public void join(String memberId,String password){
        membersRepository.save(memberId,password);
    }

    public void login(String memberId,String password){
        Optional<Members> member = membersRepository.findByMemberId(memberId);

        if(member.isEmpty()){
            System.out.println("해당 아이디가 존재하지 않습니다.");
        }else if(member.get().getPassword().equals(password)){
            System.out.println("로그인 되었습니다.");
        }else{
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
    }
}
