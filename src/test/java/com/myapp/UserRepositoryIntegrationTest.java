package com.myapp;

import static org.assertj.core.api.Assertions.assertThat;

import com.myapp.model.User;
import com.myapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByName_thenReturnUser() {
        User user = new User("john", "john@example.com");
        entityManager.persistAndFlush(user);

        User found = userRepository.findByName(user.getName());
        assertThat(found.getName()).isEqualTo(user.getName());
    }
}

