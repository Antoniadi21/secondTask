package com.example.secondlab.Service;

import com.example.secondlab.Models.User;
import com.example.secondlab.Models.UserPrincipal;
import com.example.secondlab.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getByLogin(String login) {
        return userRepository.getByLogin(login).orElse(null);
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email).orElse(null);
    }

    public void save(String login, String email, String password) {
        User user = new User();

        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);

        userRepository.insertUserIntoTable(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.getByLogin(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user.get());
    }
}
