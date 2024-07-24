package com.myapp;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);  // Change method name to match the test
}


