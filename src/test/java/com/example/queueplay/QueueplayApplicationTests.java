package com.example.queueplay;

import com.example.queueplay.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
class QueueplayApplicationTests {

    @Autowired
    EntityManager em;
    @Test
    void contextLoads() {
        User user = new User();
        em.persist(user);

        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
    }

}
