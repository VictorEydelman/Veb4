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
//@NamedQueries({
        //@NamedQuery(name=UserOn.FIND_ALL, query="SELECT u FROM UserOn u"),
        //@NamedQuery(name=UserOn.FIND_BY_LOGIN_PASSWORD, query="SELECT u FROM UserOn u WHERE u.login=:login"),
//})
public class UserOn implements Serializable {
    //public static final String FIND_ALL = "UserOne.findAll";
    //public static final String FIND_BY_LOGIN_PASSWORD = "UserOne.findByLoginAndPassword";
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
    /*@OneToMany
    @JoinTable(
            name = "users_datao",
            joinColumns = @JoinColumn(name = "userOn_login"),
            inverseJoinColumns = @JoinColumn(name = "dat_id")
    )
    private Collection<Datao> dataos;*/
}
