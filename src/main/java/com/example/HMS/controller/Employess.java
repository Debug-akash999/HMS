package com.example.HMS.controller;

import com.example.HMS.model.EmpEntity;
import com.example.HMS.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/emp")
public class Employess {
    @Autowired

    private EmpService service;

    public Employess(EmpService service) {
        this.service = service;
    }


  @RequestMapping(value="/save", method = RequestMethod.POST)

    public ResponseEntity<EmpEntity> save(@RequestBody EmpEntity emp){

         EmpEntity saved=service.save(emp);
         return ResponseEntity.ok(saved);
  }




}
