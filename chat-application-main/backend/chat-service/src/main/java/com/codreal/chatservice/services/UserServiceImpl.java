package com.codreal.chatservice.services;

import com.codreal.chatservice.exceptions.UserAlreadyExistException;
import com.codreal.chatservice.exceptions.UserNotFoundException;
import com.codreal.chatservice.model.User;
import com.codreal.chatservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getall() throws UserNotFoundException {
        List<User> users=userRepository.findAll();
        if (users.isEmpty()){
            throw new UserNotFoundException();
        }else {
           return users;
        }
    }

    @Override
    public User addUser(User user) throws UserAlreadyExistException {
       Optional<User> user1=userRepository.findById(user.getUserName());

       if (user1.isPresent()){
           throw new UserAlreadyExistException();
       }else {
           return userRepository.save(user);
       }
    }


    @Override
    public Optional<User> findByUsername(String username) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findByUserName(username);

        if (userOptional.isPresent()) {
            return userOptional;
        } else {
            throw new UserNotFoundException();
        }
    }




}
