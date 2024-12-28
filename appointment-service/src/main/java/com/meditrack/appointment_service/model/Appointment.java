package com.meditrack.appointment_service.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Appointment {
    @Id
    private String id;
    private String pId;
    private String doctorName;
    private String appointmentDate;
    private String status;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPatientId() { return pId; }
    public void setPatientId(String patientId) { this.pId = patientId; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public String getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(String appointmentDate) { this.appointmentDate = appointmentDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}
