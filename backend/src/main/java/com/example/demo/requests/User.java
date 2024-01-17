package com.example.demo.requests;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {
    @NotNull
    private String login;
    @NotNull private String password;
}