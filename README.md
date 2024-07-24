# Summary
Unit Tests: Validate the functionality of individual methods or classes in isolation (e.g., UserServiceTest).

Integration Tests: Validate the interaction between multiple components and ensure they work together correctly (e.g., UserRepositoryIntegrationTest and UserServiceIntegrationTest).

Controller Tests: Validate that the API endpoints are functioning correctly and interacting properly with the service layer (e.g., UserControllerTest).

These tests are crucial for ensuring that your application is robust, reliable, and behaves as expected in different scenarios.

# UserControllerTest.java

Purpose: To test the UserController class and ensure that it correctly handles HTTP requests and responses.

Example Test Explanation:

This test verifies that when the /users endpoint is called, it returns a list of users in JSON format.

package com.myapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void givenUsers_whenGetUsers_thenReturnJsonArray() throws Exception {
        User user1 = new User("John");
        User user2 = new User("Jane");

        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        mockMvc.perform(get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[1].name").value("Jane"));
    }
}

Explanation:
Setup: Initializes MockMvc and sets up the controller for testing.
Test: Simulates a GET request to /users and checks if the response contains a JSON array with users named "John" and "Jane".

# UserRepositoryIntegrationTest.java

Purpose: To test the UserRepository class and ensure it interacts correctly with the database.

Example Test Explanation:

This test verifies that the repository can find a user by their name.

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
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByName_thenReturnUser() {
        User user = userRepository.findByName("John");
        assertNotNull(user);
        assertEquals("John", user.getName());
    }
}
Explanation:

Test: Retrieves a user by name "John" from the database and checks if the user's name matches "John".

# UserServiceIntegrationTest.java

Purpose: To test the UserService class in an integration context, ensuring it correctly interacts with the repository and other components.

This test verifies that the service can find a user by their ID.

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
        User user = userService.getUserById(1L);
        assertNotNull(user);
        assertEquals("John", user.getName());
    }
}
Explanation:

Test: Retrieves a user by ID 1 from the service and checks if the user's name matches "John".

# UserServiceTest.java

Purpose: To test the UserService class in isolation (unit test), ensuring individual methods work as expected.

Example Test Explanation:

This test verifies that the service can find a user by their ID using mock objects.

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
Explanation:

Setup: Initializes mock objects.
Test: Mocks the repository's findById method to return a user named "John" when called with ID 1. Verifies that the service returns the correct user.
