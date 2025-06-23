package com.blogdev.members.repository;

import com.blogdev.members.domain.Members;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMembersRepositoryTest {
    MembersRepository membersRepository=new MemoryMembersRepository();

    @Test
    @DisplayName("회원 저장 & 회원 조회")
    void saveAndget(){
        membersRepository.save("aa","bb");

        assertThat(membersRepository.count()).isEqualTo(1);

        Optional<Members> m1=membersRepository.findByMemberId("aa");

        assertThat(m1.get().getMemberId()).isEqualTo("aa");

    }
}
