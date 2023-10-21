package com.example.KhanyisileMndaweni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.KhanyisileMndaweni.entities.User;
import com.example.KhanyisileMndaweni.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String saveUser(User user) {

        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()|| user.getEmail().isEmpty()) {
            return "Fields must not be empty.";
        }

        if (userRepository.findByUsername(user.getUsername()) != null || userRepository.findByUsername(user.getEmail()) != null) {
            return "User already exists.";
        }
        User userTosave = new User(null, null, null, null, null);
        userTosave.setUsername(user.getUsername());
        userTosave.setPassword(user.getPassword());
        userTosave.setEmail(user.getEmail());

         if (getLargestUserId() < 3) {
            userTosave.setRole("Admin");
        } else {
             userTosave.setRole("User");
       }
        userRepository.save(userTosave);
        return "User saved successfully.";
    }
    public Long getLargestUserId() {
        List<User> users = userRepository.findAll();
        Long[] userIds = new Long[users.size()];
        for (int i = 0; i < users.size(); i++) {
            userIds[i] = users.get(i).getId();
                }

                if (userIds.length == 0) {
                        return (long) 0;
        }
        Long largestId = userIds[0];
        for (Long id : userIds) {
            if (id > largestId) {
                largestId = id;
            }
        }
        return largestId;
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

