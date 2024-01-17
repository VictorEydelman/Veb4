package com.example.demo.requests;


import javax.validation.constraints.NotNull;

@lombok.Data
public class Data {
    @NotNull
    private String x;
    @NotNull private String y;
    @NotNull private String r;

}
