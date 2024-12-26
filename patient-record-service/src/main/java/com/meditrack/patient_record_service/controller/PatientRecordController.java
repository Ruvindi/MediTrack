package com.meditrack.patient_record_service.controller;


import com.meditrack.patient_record_service.model.PatientRecord;
import com.meditrack.patient_record_service.service.PatientRecordService;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientRecordController {
    private final PatientRecordService patientService;

    public PatientRecordController(PatientRecordService patientService) {
        this.patientService = patientService;
    }

    
    @PostMapping
    public PatientRecord addPatient(@RequestBody PatientRecord patient) {
        return patientService.savePatient(patient);
    }

    // READ - Get all patients
    @GetMapping
    public List<PatientRecord> getAllPatients() {
        return patientService.getAllPatients();
    }

    // READ - Get a specific patient by ID
    @GetMapping("/{id}")
    public PatientRecord getPatientById(@PathVariable String id) {
        return patientService.getPatientById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
    }

    // UPDATE - Update an existing patient
    @PutMapping("/{id}")
    public PatientRecord updatePatient(@PathVariable String id, @RequestBody PatientRecord patientDetails) {
        return patientService.updatePatient(id, patientDetails);
    }

    // DELETE - Delete a patient by ID
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable String id) {
        patientService.deletePatient(id);
    }
}
