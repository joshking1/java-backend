package com.myapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void whenValidUserId_thenUserShouldBeFound() {
        User user = new User();
        user.setName("John");
        user.setEmail("john@example.com");
        userService.saveUser(user);

        User foundUser = userService.getUserById(user.getId());
        assertNotNull(foundUser);
        assertEquals("John", foundUser.getName());
    }
}
