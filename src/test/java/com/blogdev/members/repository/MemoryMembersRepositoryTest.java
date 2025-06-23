package com.blogdev.members.repository;

import com.blogdev.members.domain.Members;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MemoryMembersRepositoryTest {

    @Autowired
    MembersRepository membersRepository;

    @Test
    @DisplayName("회원 저장 & 회원 조회")
    void saveAndget(){
        membersRepository.save("마에다 리쿠");
        membersRepository.save("오시온");
        membersRepository.save("토쿠노 유우시");
        membersRepository.save("김대영");
        membersRepository.save("사쿠야");
        membersRepository.save("료");

        assertThat(membersRepository.count()).isEqualTo(6);

        Members m1=membersRepository.findById(1);
        Members m2=membersRepository.findById(2);
        Members m3=membersRepository.findById(3);
        Members m4=membersRepository.findById(4);
        Members m5=membersRepository.findById(5);
        Members m6=membersRepository.findById(6);

        assertThat(m1.getName()).isEqualTo("마에다 리쿠");
        assertThat(m2.getName()).isEqualTo("오시온");
        assertThat(m3.getName()).isEqualTo("토쿠노 유우시");
        assertThat(m4.getName()).isEqualTo("김대영");
        assertThat(m5.getName()).isEqualTo("사쿠야");
        assertThat(m6.getName()).isEqualTo("료");

    }
}
