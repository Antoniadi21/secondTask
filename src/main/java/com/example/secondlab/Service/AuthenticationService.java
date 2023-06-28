package com.example.secondlab.Service;

import com.example.secondlab.Controllers.Authentication.AuthenticationRequest;
import com.example.secondlab.Controllers.Authentication.AuthenticationResponse;
import com.example.secondlab.Controllers.Authentication.RegisterRequest;
import com.example.secondlab.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AuthenticationResponse register(RegisterRequest request) {

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
    }
}
