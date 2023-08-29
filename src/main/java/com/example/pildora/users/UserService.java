package com.example.pildora.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String userId, User user) {
        User existingUser = userRepository.findById(userId).get();

        existingUser.setName(user.getName());

        return userRepository.save(existingUser);
    }

    public String deleteUser(String userId) {
        userRepository.deleteById(userId);

        return "User deleted.";
    }
}
