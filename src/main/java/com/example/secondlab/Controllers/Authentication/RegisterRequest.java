package com.example.secondlab.Controllers.Authentication;

public class RegisterRequest {
    private String login;
    private String email;
    private String password;
    private String repeatedPassword;

    public RegisterRequest(String login, String email, String password, String repeatedPassword) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }
}
