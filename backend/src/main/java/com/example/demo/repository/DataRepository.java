package com.example.demo.repository;


import com.example.demo.model.Datas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<Datas,Long> {
    //List<DataONE> ();
    List<Datas> findAllByLogin (String login);
    void deleteAllByLogin (String login);

}