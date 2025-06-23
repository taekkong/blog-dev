package com.blogdev.members.repository;

import com.blogdev.members.domain.Members;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemoryMembersRepositoryTest {

    @Test
    @DisplayName("회원 저장")
    void save(){
        MemoryMembersRepository memoryMembersRepository = new MemoryMembersRepository();
        memoryMembersRepository.save("홍길동");

        Assertions.assertThat(memoryMembersRepository.findById(1)).isEqualTo("홍길동");
    }
}
