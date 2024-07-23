package com.myapp;

import java.util.List;

public interface UserService {
    User findUserById(Long id);
    List<User> getAllUsers();
}



