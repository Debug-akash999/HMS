package com.example.HMS.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="EMPDeatils")
public class EmpEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;

    private String Empname;
    private String EmpRole;
     private Double salary;
}
