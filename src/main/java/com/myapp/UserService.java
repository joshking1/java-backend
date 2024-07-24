package com.myapp;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User findUserById(long id);
}
