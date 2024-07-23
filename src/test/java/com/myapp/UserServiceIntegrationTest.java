package com.myapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void whenValidUserId_thenUserShouldBeFound() {
        User user = userService.findUserById(1L);
        assertNotNull(user);
        assertEquals("John", user.getName());
    }
}
