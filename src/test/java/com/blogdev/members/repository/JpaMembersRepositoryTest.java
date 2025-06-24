package com.blogdev.members.repository;

import com.blogdev.members.domain.Members;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("mysql")
public class JpaMembersRepositoryTest {
    @Autowired
    JpaMembersRepository jpaMembersRepository;

    @Test
    @Transactional
    @Rollback(false)
    @DisplayName("회원 저장")
    public void save() {
        Members member = new Members("aa","bb");

        Members saved = jpaMembersRepository.save(member);
        Assertions.assertThat(member.getMemberId()).isEqualTo(saved.getMemberId());
    }
}
