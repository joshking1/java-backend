package com.myapp;

import static org.assertj.core.api.Assertions.assertThat;

import com.myapp.model.User;
import com.myapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void whenValidUserId_thenUserShouldBeFound() {
        User user = new User("john", "john@example.com");
        userService.saveUser(user);

        User found = userService.getUserById(user.getId());
        assertThat(found.getName()).isEqualTo(user.getName());
    }
}
