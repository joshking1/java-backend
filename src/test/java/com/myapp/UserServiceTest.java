package com.myapp;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

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
        User user = new User();
        user.setId(1L);
        user.setName("John");
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        User found = userService.getUserById(1L);

        assertEquals("John", found.getName());
    }
}
