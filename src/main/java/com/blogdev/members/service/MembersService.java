package com.blogdev.members.service;

import com.blogdev.members.entity.Members;
import com.blogdev.members.dto.LoginRequestDto;
import com.blogdev.members.repository.MembersRepository;
import com.blogdev.members.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MembersService {

    private final MembersRepository membersRepository;

    private Members toEntity(LoginRequestDto loginRequestDto) {
        String memberId=loginRequestDto.getMemberId();
        String password=loginRequestDto.getPassword();

        return new Members(memberId,password);
    }

    public Members join(LoginRequestDto loginRequestDto) {
        Members members=toEntity(loginRequestDto);

        return membersRepository.save(members);
    }

    public String login(LoginRequestDto loginRequestDto){
        Members members=toEntity(loginRequestDto);
        Optional<Members> members1 = membersRepository.findById(members.getId());

        if(members1.isEmpty()){
            return "해당 아이디가 존재하지 않습니다.";
        }else if(members1.get().getPassword().equals(members.getPassword())){
            return "로그인 되었습니다.";
        }else{
            return "비밀번호가 일치하지 않습니다.";
        }
    }
}
