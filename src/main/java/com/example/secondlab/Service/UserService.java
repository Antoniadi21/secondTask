package com.example.secondlab.Service;

import com.example.secondlab.Models.User;
import com.example.secondlab.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

    public void save(User user) {
        userRepository.insertUserIntoTable(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.getByLogin(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        User user = userOptional.get();
        Set<String> set = new HashSet<>();
        set.add("USER");
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                set.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }
}
