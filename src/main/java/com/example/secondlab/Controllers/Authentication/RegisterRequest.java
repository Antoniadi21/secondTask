package com.example.secondlab.Controllers.Authentication;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterRequest {
    private String login;
    private String email;
    private String password;
}
