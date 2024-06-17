package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table
@Data
public class UserOn implements Serializable {
    @Column
    private String login;
    @Column
    private String password;

    public UserOn(String login, String password) {
        this.login=login;
        this.password=password;
    }

    public UserOn() {

    }

    public void setLogin(String login){
        this.login=login;
    }

    @Id
    public String getLogin(){
        return login;
    }
}
