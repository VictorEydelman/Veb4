package com.example.demo.services;

import com.example.demo.model.UserOn;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService  {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Transactional
    public void register(String login,String password){
        UserOn userOne = new UserOn(login,password);
        userRepository.save(userOne);
        System.out.println(userRepository.findAll());
    }
    @Transactional
    public UserOn findByLogin(String login){
        return userRepository.getByLogin(login);
    }
    @Transactional
    public UserOn findByLoginAndPassword(String login,String password){
        return userRepository.getByLoginAndPassword(login,password);
    }
}
