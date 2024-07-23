package com.myapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        // Ensure the database is clean before each test
        entityManager.getEntityManager().createNativeQuery("DROP ALL OBJECTS").executeUpdate();
        entityManager.getEntityManager().createNativeQuery("CREATE TABLE hibernate_sequence (next_val BIGINT)").executeUpdate();
        entityManager.getEntityManager().createNativeQuery("INSERT INTO hibernate_sequence (next_val) VALUES (1)").executeUpdate();
    }

    @Test
    public void whenFindByName_thenReturnUser() {
        // given
        User user = new User();
        user.setName("test");
        user.setEmail("test@example.com");
        entityManager.persistAndFlush(user);

        // when
        User found = userRepository.findByName(user.getName());

        // then
        assertThat(found.getName()).isEqualTo(user.getName());
    }
}
