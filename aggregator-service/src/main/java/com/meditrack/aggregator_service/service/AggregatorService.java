package com.meditrack.aggregator_service.service;

import com.meditrack.aggregator_service.model.Appointment;
import com.meditrack.aggregator_service.model.PatientRcord;
import com.meditrack.aggregator_service.model.DoctorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.redshiftdata.model.*;

import java.util.List;

@Service
public class AggregatorService {

    @Autowired
    private MongoTemplate mongoTemplate;  // MongoDB Template

    @Autowired
    private RedshiftService redshiftService;  // Service for Redshift operations

    // Fetch data from MongoDB
    public List<PatientRcord> getPatients() {
        return mongoTemplate.findAll(PatientRcord.class);
    }

    public List<Appointment> getAppointments() {
        return mongoTemplate.findAll(Appointment.class);
    }

    public List<DoctorInfo> getDoctors() {
        return mongoTemplate.findAll(DoctorInfo.class);
    }

    // Aggregation logic: Combine data from Patients, Doctors, and Appointments
    public void aggregateData() {
        List<PatientRcord> patients = getPatients();
        List<Appointment> appointments = getAppointments();
        List<DoctorInfo> doctors = getDoctors();

        // Perform aggregation logic here (e.g., number of appointments per doctor)
        for (DoctorInfo doctor : doctors) {
            long appointmentCount = appointments.stream()
                .filter(a -> a.getDoctorName().equals(doctor.getName()))
                .count();

            // Insert the aggregated data into Redshift
            String insertSQL = "INSERT INTO appointment_aggregation (doctor_name, appointment_count) VALUES ('%s', %d)";
            redshiftService.insertData(insertSQL, doctor.getName(), appointmentCount);
        }
    }

    // Scheduled task to run every hour (for example)
    @Scheduled(cron = "0 0 * * * ?")
    public void runAggregation() {
        aggregateData();
    }
}
