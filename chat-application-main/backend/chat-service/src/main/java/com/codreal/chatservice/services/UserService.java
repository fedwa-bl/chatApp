package com.codreal.chatservice.services;

import com.codreal.chatservice.exceptions.UserAlreadyExistException;
import com.codreal.chatservice.exceptions.UserNotFoundException;
import com.codreal.chatservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getall() throws UserNotFoundException;

    User addUser(User user) throws UserAlreadyExistException;

   Optional <User> findByUsername(String username)  throws UserNotFoundException;
}
