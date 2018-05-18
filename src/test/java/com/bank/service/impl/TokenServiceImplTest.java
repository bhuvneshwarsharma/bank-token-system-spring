package com.bank.service.impl;

import com.bank.repo.CustomerTokenRepo;
import com.bank.TokenService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by bhuvneshwars on 17/5/18.
 */
@RunWith(SpringRunner.class)
public class TokenServiceImplTest {

    @TestConfiguration
    static class TokenServiceImplTestContextConfiguration {

        @Bean
        public TokenService tokenServiceImpl() {
            return new TokenServiceImpl();
        }
    }

    @Autowired
    private TokenService tokenService;
    @MockBean
    private CustomerTokenRepo customerTokenRepo;


}
