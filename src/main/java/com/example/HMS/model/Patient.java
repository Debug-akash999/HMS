package com.example.HMS.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
//@Table("patients")
@Data
public class Patient {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String reasons;
}

