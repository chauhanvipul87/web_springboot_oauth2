package com.iic.example.service;

import java.util.Collection;
import java.util.Optional;

import com.iic.example.domain.User;
import com.iic.example.domain.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
