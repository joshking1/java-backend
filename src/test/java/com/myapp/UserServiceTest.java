package com.myapp;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void whenValidUserId_thenUserShouldBeFound() {
        User user = new User("John", "john@example.com");
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));

        User found = userService.findUserById(1L);

        assertNotNull(found);
        assertEquals("John", found.getName());
    }

    @Test
    public void whenGetAllUsers_thenReturnUserList() {
        User user1 = new User("John", "john@example.com");
        User user2 = new User("Jane", "jane@example.com");

        List<User> users = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(users);

        List<User> foundUsers = userService.getAllUsers();

        assertEquals(2, foundUsers.size());
        assertEquals("John", foundUsers.get(0).getName());
        assertEquals("Jane", foundUsers.get(1).getName());
    }
}

