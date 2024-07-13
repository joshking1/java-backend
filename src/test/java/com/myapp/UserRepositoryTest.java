package com.myapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        // Create a new user and save it to the database
        User user = new User();
        user.setUsername("john_doe");
        user.setPassword("password123");
        userRepository.save(user);

        // Find the user by username
        User foundUser = userRepository.findByUsername("john_doe");

        // Validate the user was found
        assertNotNull(foundUser);
        assertEquals("john_doe", foundUser.getUsername());
    }
}
