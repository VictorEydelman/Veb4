package com.example.demo.controllers;


import com.example.demo.configuration.sec.jwt.JWTUtil;
import com.example.demo.model.Datas;
import com.example.demo.model.UserOn;
import com.example.demo.requests.Data;
import com.example.demo.services.DataService;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/data")
@AllArgsConstructor
public class DataController {
    private final DataService dataService;
    private final UserService userService;
    private final JWTUtil jwtUtil;


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<String> addData(@Valid @RequestBody Data dataOne, HttpServletRequest req){
        float x = Float.parseFloat(dataOne.getX());
        float y= (float) Double.parseDouble(dataOne.getY());
        float r= (float) Double.parseDouble(dataOne.getR());
        UserOn userOn = userService.findByLogin(jwtUtil.getUsername(jwtUtil.resolveToken(req)));
        dataService.register(x,y,r,check(x,y,r),new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(new Date()),userOn.getLogin());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Datas>> getData(HttpServletRequest req){
        UserOn userOn = userService.findByLogin(jwtUtil.getUsername(jwtUtil.resolveToken(req)));
        List<Datas> datas=dataService.getAllByLogin(userOn.getLogin());
        return new ResponseEntity<>(datas,HttpStatus.OK);
    }
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<String> deleteData(HttpServletRequest req){
        UserOn userOn = userService.findByLogin(jwtUtil.getUsername(jwtUtil.resolveToken(req)));
        dataService.deleteByLogin(userOn.getLogin());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public String check(float x, float y, float r){
        if((x>=0 && y<=0 && y>=(x/2-Math.abs(r)/2)) ||
                (x<=0 && y<=0 && (Math.pow(x,2)+Math.pow(y,2))<=Math.pow(r,2))||
                (x<=0 && y>=0 && y<=Math.abs(r)/2 && x>=-Math.abs(r))){
            return "Входит";
        } else {
            return "Не входит";
        }
    }
}
