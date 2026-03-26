package com.example.HMS.service;

import com.example.HMS.model.EmpEntity;
import com.example.HMS.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

    @Autowired

  private final EmpRepo re;

    public EmpService(EmpRepo re) {
        this.re = re;
    }

    public EmpEntity save(EmpEntity rne){
        return re.save(rne);
    }
}
