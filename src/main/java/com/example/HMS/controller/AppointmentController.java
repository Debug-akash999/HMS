package com.example.HMS.controller;

import com.example.HMS.model.Appointment;
import com.example.HMS.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService serr;

    public AppointmentController(AppointmentService serr) {
        this.serr = serr;
    }


    @PostMapping("/book")
    public ResponseEntity<Appointment> save(
            @RequestParam Long patientId,
            @RequestParam Long doctorId,
            @RequestBody Appointment appp) {

        return ResponseEntity.ok(
                serr.addAll(doctorId, patientId, appp)
        );
    }


    @GetMapping("/get")
    public ResponseEntity<List<Appointment>> getAll() {
        return ResponseEntity.ok(serr.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<Appointment> updateByID(
            @RequestParam Long appointmentId,
            @RequestParam Long doctorId,
            @RequestParam Long patientId,
            @RequestBody Appointment apoo) {

        Appointment updated = serr.updateById(
                appointmentId,
                doctorId,
                patientId,
                apoo
        );

        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getById(@PathVariable Long id) {
        return ResponseEntity.ok(serr.getById(id));
    }
}