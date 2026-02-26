package com.example.HMS.repo;

import com.example.HMS.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<Patient ,Long> {
}
