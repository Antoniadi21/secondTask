package com.example.secondlab.Service;

import com.example.secondlab.Controllers.Authentication.AuthenticationRequest;
import com.example.secondlab.Controllers.Authentication.AuthenticationResponse;
import com.example.secondlab.Controllers.Authentication.RegisterRequest;
import com.example.secondlab.Exceptions.AppError;
import com.example.secondlab.Models.User;
import com.example.secondlab.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthenticationResponse register(RegisterRequest request) throws AppError {
        if (userService.getByLogin(request.getLogin()) != null) {
            throw new AppError(HttpStatus.BAD_REQUEST.value(),
                    "Пользователь с таким логином уже существует");
        }
        User user = new User();
        user.setLogin(request.getLogin());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userService.save(user);

        return new AuthenticationResponse(jwtService.generateToken(user));
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws AppError {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));
        } catch (BadCredentialsException e) {
            throw new AppError(HttpStatus.UNAUTHORIZED.value(), "Неправильный логин или пароль");
        }

        UserDetails userDetails = userService.loadUserByUsername(request.getLogin());
        return new AuthenticationResponse(jwtService.generateToken(userDetails));
    }
}
