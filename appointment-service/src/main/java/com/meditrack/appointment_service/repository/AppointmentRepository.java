package com.meditrack.appointment_service.repository;


import com.meditrack.appointment_service.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
}
