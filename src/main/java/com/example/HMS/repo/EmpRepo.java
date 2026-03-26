package com.example.HMS.repo;

import com.example.HMS.model.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<EmpEntity ,Long> {
}
