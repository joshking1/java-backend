package com.myapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void whenValidUserId_thenUserShouldBeFound() {
        User user = new User("John");
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));

        User found = userService.getUserById(1L);

        assertNotNull(found);
        assertEquals("John", found.getName());
    }
}
