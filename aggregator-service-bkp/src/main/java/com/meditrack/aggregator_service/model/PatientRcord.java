package com.meditrack.aggregator_service.model;

public class PatientRcord {
    private String pid;
    private String pname;
    private String medicalHistory;
    private String prescriptions;


    // Getter and Setter for pid
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    // Getter and Setter for pname
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    // Getter and Setter for medicalHistory
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    // Getter and Setter for prescriptions
    public String getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }
}
