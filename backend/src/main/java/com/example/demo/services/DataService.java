package com.example.demo.services;

import com.example.demo.model.Datas;
import com.example.demo.repository.DataRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DataService {
    private final DataRepository dataRepository;
    public DataService(DataRepository dataRepository){
        this.dataRepository = dataRepository;
    }
    @Transactional
    public void register(float x, float y, float r, String result, String querytime, String login){
        Datas dataon = new Datas(0,x,y,r,result,querytime,login);
        dataRepository.save(dataon);
    }
    @Transactional
    public List<Datas> getAllByLogin(String login){
        return dataRepository.findAllByLogin(login);
    }
    @Transactional
    public void deleteByLogin(String login){
        dataRepository.deleteAllByLogin(login);
    }
}
