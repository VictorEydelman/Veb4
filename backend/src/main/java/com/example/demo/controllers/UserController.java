package com.example.demo.controllers;


import com.example.demo.configuration.sec.jwt.JWTUtil;
import com.example.demo.model.UserOn;
import com.example.demo.requests.User;
import com.example.demo.services.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/users")
public class UserController {
    private final AuthenticationManager authenticationManager= new AuthenticationManager(){
        @Override
        public org.springframework.security.core.Authentication authenticate(org.springframework.security.core.Authentication authentication) throws AuthenticationException {
            return null;
        }
    };
    private UserService userService;
    private JWTUtil jwtUtil;
    public UserController(UserService userService, JWTUtil jwtUtil){
        this.userService=userService;
        this.jwtUtil=jwtUtil;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<String> loginUser(@Valid @RequestBody User user){
        String login = user.getLogin();
        String password = HashUtil.digestPassword(user.getPassword());
        System.out.println(4);
        UserOn userOn =userService.findByLoginAndPassword(login,password);
        if(userOn!=null){
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login,password));
            String token = jwtUtil.generateToken(login,new ArrayList<String>(){{add("USER");}});
            System.out.println(token+"sxvcbn");
            //String token="";
            return ResponseEntity.ok(token);
        }
        return new ResponseEntity<>("Пользователя с таким логином и паролем не существует",HttpStatus.NOT_FOUND);
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<String> registerUser(@Valid @RequestBody User user){
        String login = user.getLogin();
        String password = HashUtil.digestPassword(user.getPassword());
        UserOn userOn =userService.findByLogin(login);
        System.out.println(userOn);
        if(userOn==null) {
            userService.register(login, password);
            System.out.println("hk");

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login,password));
            String token = jwtUtil.generateToken(login,new ArrayList<String>(){{add("USER");}});
            return ResponseEntity.ok(token);
        }
        return new ResponseEntity<>("Пользователь с таким логином существует",HttpStatus.BAD_REQUEST);
    }
}

