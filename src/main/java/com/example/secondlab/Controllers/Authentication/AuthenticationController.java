package com.example.secondlab.Controllers.Authentication;

import com.example.secondlab.Exceptions.AppError;
import com.example.secondlab.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @GetMapping("/register")
    public ModelAndView getRegisterView() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("registration");

        return mv;
    }

    @PostMapping( "/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) throws AppError {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping( "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) throws AppError {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
