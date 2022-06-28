package com.example.queueplay.user;

import com.example.queueplay.user.dto.UserLoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class UserTest {

    @PersistenceContext
    EntityManager em;
    @Autowired
    private MockMvc mvc;


    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setup() {
        User build = User.builder()
                .role("ROLE_USER")
                .name("태규")
                .password(passwordEncoder.encode("1234"))
                .email("suker80@naver.com")
                .build();
        em.persist(build);

    }


    @Test
    @DisplayName("로그인 테스트")
    public void login() throws Exception {
        User user = userRepository.findByEmail("suker80@naver.com");
        Assertions.assertThat(user).isNotNull();
        UserLoginRequest userLoginRequest = new UserLoginRequest("suker80@naver.com", "1234");
        mvc.perform(post("http://localhost:8080/login")
                        .content(objectMapper.writeValueAsString(userLoginRequest))
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("토큰 검증")
    public void tokenValid() throws Exception {
        User user = userRepository.findByEmail("suker80@naver.com");
        Assertions.assertThat(user).isNotNull();
        UserLoginRequest userLoginRequest = new UserLoginRequest("suker80@naver.com", "1234");
        MvcResult mvcResult = mvc.perform(post("http://localhost:8080/login")
                        .content(objectMapper.writeValueAsString(userLoginRequest))
                        .contentType("application/json"))
                .andReturn();
        String token = mvcResult.getResponse().getHeader("Authorization");

        mvc.perform(get("http://localhost:8080/user/test")
                        .header("Authorization", token)
                        .contentType("application/json"))
                .andExpect(status().isOk());

    }

}