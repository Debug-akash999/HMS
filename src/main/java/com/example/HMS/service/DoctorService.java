package com.example.HMS.service;

import com.example.HMS.model.Doctor;
import com.example.HMS.repo.DoctorRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private final DoctorRepository rep;

    public DoctorService(DoctorRepository doct) {
        this.rep = doct;
    }

    public Doctor addAll(Doctor doct) {
        return rep.save(doct);
    }

    public List<Doctor> getAll() {
        return rep.findAll()
                ;
    }

    public Doctor updateById(Long id) {
        return rep.findById(id).orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
    }

    public void deleteById(Long id) {
        rep.deleteById(id);
    }

    public Doctor save(Doctor doctor) {
        return rep.save(doctor);

    }
}
