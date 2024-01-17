package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Immutable
@Getter
@Data
@Table(name = "dataso")
@Setter
@Builder
@NamedQueries({
        @NamedQuery(name = com.example.demo.model.Datas.FIND_ALL, query = "SELECT p FROM Datas p")
})
public class Datas implements Serializable {
    public static final String FIND_ALL = "Datao.findAll";
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private float x;
    @Column
    private float y;
    @Column
    private float r;
    @Column
    private String result;
    @Column
    private String time;
    @Column
    private String login;

    public Datas(int id, float x, float y, float r, String result, String querytime,String login) {
        this.id=id;
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
        this.time = querytime;
        this.login=login;
    }

    public Datas() {

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public void setX(float x) {
        this.x=x;
    }

    public void setY(float y) {
        this.y=y;
    }

    public void setR(float r) {
        this.r=r;
    }


    public String isResult() {
        return result;
    }

    public String getTime() {
        return time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }
}
