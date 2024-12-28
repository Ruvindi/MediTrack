package com.meditrack.aggregator_service.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DoctorInfo {
    
    private String id;
    private String name;
    private String specialization;
    private String contactNumber;
    private String email;
    
        // Getter and Setter for id
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
        // Getter and Setter for name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
        // Getter and Setter for specialization
    public String getSpecialization() {
        return specialization;
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
        // Getter and Setter for contactNumber
    public String getContactNumber() {
        return contactNumber;
    }
    
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
        // Getter and Setter for email
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
  
    
}
