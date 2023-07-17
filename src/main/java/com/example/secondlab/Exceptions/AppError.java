package com.example.secondlab.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppError extends Exception {
    private int status;


    public AppError(int status, String message) {
        super(message);
        this.status = status;
    }
}
