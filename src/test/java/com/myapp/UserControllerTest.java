package com.myapp;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@WebMvcTest(UserController.class)
@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testSignup() throws Exception {
        // Mock the service layer
        when(userService.signup(any(User.class))).thenReturn("User registered successfully");

        // Prepare the signup request
        String signupRequest = "{ \"username\": \"john_doe\", \"password\": \"password123\" }";

        // Perform the request and validate the response
        mockMvc.perform(post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(signupRequest))
                .andExpect(status().isOk())
                .andExpect(content().string("User registered successfully"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testLogin() throws Exception {
        // Mock the service layer
        when(userService.login(any(User.class))).thenReturn("Login successful");

        // Prepare the login request
        String loginRequest = "{ \"username\": \"john_doe\", \"password\": \"password123\" }";

        // Perform the request and validate the response
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(loginRequest))
                .andExpect(status().isOk())
                .andExpect(content().string("Login successful"))
                .andDo(MockMvcResultHandlers.print());
    }
}

