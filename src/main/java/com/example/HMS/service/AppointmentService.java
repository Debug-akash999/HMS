package com.example.HMS.service;

import com.example.HMS.model.Appointment;
import com.example.HMS.model.Doctor;
import com.example.HMS.model.Patient;
import com.example.HMS.repo.AppointmentRepository;
import com.example.HMS.repo.DoctorRepository;
import com.example.HMS.repo.PatientsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository apo;
    private final DoctorRepository doct;
    private final PatientsRepository patin;

    public AppointmentService(AppointmentRepository apo,
                              DoctorRepository doct,
                              PatientsRepository patin) {
        this.apo = apo;
        this.doct = doct;
        this.patin = patin;
    }


    public Appointment addAll(Long doctorId, Long patientId, Appointment apoo) {

        Doctor doctor = doct.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Patient patient = patin.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        apoo.setDoctor(doctor);
        apoo.setPatient(patient);
        apoo.setStatus("Booked");

        return apo.save(apoo);
    }
    public List<Appointment> getAll() {
        return apo.findAll();
    }
    public Appointment getById(Long id) {
        return apo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public Appointment updateById(Long appointmentId,
                                  Long doctorId,
                                  Long patientId,
                                  Appointment updatedAppointment) {

        Appointment apoo = getById(appointmentId);

        Doctor doctor = doct.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Patient patient = patin.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        apoo.setAppointmentDate(updatedAppointment.getAppointmentDate());
        apoo.setDoctor(doctor);
        apoo.setPatient(patient);
        apoo.setStatus("Booked");

        return apo.save(apoo);
    }
    public void deleteById(Long id) {
        apo.deleteById(id);
    }
}