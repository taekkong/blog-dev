package com.blogdev;

import com.blogdev.members.repository.MembersRepository;
import com.blogdev.members.service.MembersService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @Bean
    MembersService membersService(){
        return Mockito.mock(MembersService.class);

    }

}
