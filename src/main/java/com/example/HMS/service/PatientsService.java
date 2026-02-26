package com.example.HMS.service;

import com.example.HMS.model.Patient;
import com.example.HMS.repo.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientsService {
    @Autowired
    private  final PatientsRepository repo;
    public PatientsService(PatientsRepository repo){
        this.repo=repo;
    }

    public Patient addPatients(Patient patient) {
        return repo.save(patient);
    }

    public List<Patient> getAll() {
        return repo.findAll();
}
   public  Patient getById(Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
   }

    public Patient update(Patient patient){
        return repo.save(patient);
    }

    public void deleteByID(Long id){
        repo.deleteById(id);
    }


}
