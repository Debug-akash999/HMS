package com.example.HMS.controller;

import com.example.HMS.model.Doctor;
import com.example.HMS.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doct;

    @PostMapping("/save")
    public ResponseEntity<Doctor> addAll(@RequestBody Doctor d) {
        Doctor save = doct.addAll(d);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Doctor>> getAll() {
        List<Doctor> se = doct.getAll();
        return ResponseEntity.ok(se);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateById(
            @RequestBody Doctor doc,
            @PathVariable Long id) {

        Doctor d = doct.updateById(id);
        d.setName(doc.getName());
        d.setSpecialization(doc.getSpecialization());

        Doctor updated = doct.save(d);

        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getAllById(@PathVariable Long id) {
        Doctor d = doct.updateById(id);
        return ResponseEntity.ok(d);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {

doct.deleteById(id);
return ResponseEntity.ok("Delete by successfull")
;    }
}

