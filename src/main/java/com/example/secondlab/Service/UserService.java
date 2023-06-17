package com.example.secondlab.Service;

import com.example.secondlab.Models.User;
import com.example.secondlab.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getByLogin(String login) {
        return userRepository.getByLogin(login);
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public void save(String login, String email, String password) {
        User user = new User();

        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);

        userRepository.insertUserIntoTable(user);
    }
}
