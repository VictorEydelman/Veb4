package com.example.demo.repository;



import com.example.demo.model.UserOn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserOn,Long> {
    UserOn getByLoginAndPassword(String login, String password);
    UserOn getByLogin(String login);
}