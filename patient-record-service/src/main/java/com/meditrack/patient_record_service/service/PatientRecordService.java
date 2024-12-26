package com.meditrack.patient_record_service.service;

import com.meditrack.patient_record_service.model.PatientRecord;
import com.meditrack.patient_record_service.repository.PatientRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PatientRecordService {
    private final PatientRecordRepository patientRepository;

    public PatientRecordService(PatientRecordRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientRecord> getAllPatients() {
        return patientRepository.findAll();
    }

    public PatientRecord savePatient(PatientRecord patient) {
        return patientRepository.save(patient);
    }

    public Optional<PatientRecord> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    
    public PatientRecord updatePatient(String id, PatientRecord patientDetails) {
        PatientRecord patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
        
        patient.setName(patientDetails.getName());
        patient.setPrescriptions(patientDetails.getPrescriptions());
        patient.setMedicalHistory(patientDetails.getMedicalHistory());

        return patientRepository.save(patient);
    }

    
    public void deletePatient(String id) {
        PatientRecord patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
        
        patientRepository.delete(patient);
    }
}
