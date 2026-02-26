package com.example.HMS.controller;

import com.example.HMS.model.Patient;
import com.example.HMS.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.reflect.Array.get;

@RestController
@RequestMapping("/patients")
public class PatientsController {
    @Autowired
    private final PatientsService ser;
    public PatientsController(PatientsService ser){
        this.ser =ser;
    }
    @PostMapping("/post")
    public ResponseEntity<Patient> addPatients (@RequestBody Patient pa){
        Patient save=ser.addPatients(pa);
        return  ResponseEntity.ok(save);
    }
    @GetMapping("/get")
     public ResponseEntity <List<Patient>>getAll(){
        List<Patient> se =ser.getAll();
        return ResponseEntity.ok(se);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updateById(
            @RequestBody Patient patient,
            @PathVariable Long id) {

        Patient old = ser.getById(id);

        old.setName(patient.getName());
        old.setAge(patient.getAge());
        old.setReasons(patient.getReasons());

        return ResponseEntity.ok(old);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getById(@PathVariable Long id){
        Patient nk=ser.getById(id);
        return ResponseEntity.ok(nk);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {

        ser.deleteByID(id);

        return ResponseEntity.ok("Patient Deleted Successfully");
    }
    }


