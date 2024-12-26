package com.meditrack.patient_record_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PatientRecord {
    @Id
    private String pid;
    private String pname;
    private String medicalHistory;
    private String prescriptions;
    
    // Getters and Setters
    public String getId() { return pid; }
    public void setId(String id) { this.pid = id; }
    
    public String getName() { return pname; }
    public void setName(String name) { this.pname = name; }

    public String getMedicalHistory() { return medicalHistory; }
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }

    public String getPrescriptions() { return prescriptions; }
    public void setPrescriptions(String prescriptions) { this.prescriptions = prescriptions; }
}
