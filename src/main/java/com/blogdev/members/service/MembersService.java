package com.blogdev.members.service;

import com.blogdev.members.domain.Members;
import com.blogdev.members.dto.LoginRequestDto;
import com.blogdev.members.repository.JpaMembersRepository;
import com.blogdev.members.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MembersService {

    private final JpaMembersRepository jpaMembersRepository;

    public void join(LoginRequestDto loginRequestDto) {
        Members members=new  Members(loginRequestDto.getMemberId(),loginRequestDto.getPassword());
        jpaMembersRepository.save(members);
    }

    public String login(LoginRequestDto loginRequestDto){
        String memberId = loginRequestDto.getMemberId();
        String password = loginRequestDto.getPassword();
        Optional<Members> member = jpaMembersRepository.findByMemberId((memberId));

        if(member.isEmpty()){
            return "해당 아이디가 존재하지 않습니다.";
        }else if(member.get().getPassword().equals(password)){
            return "로그인 되었습니다.";
        }else{
            return "비밀번호가 일치하지 않습니다.";
        }
    }
}
