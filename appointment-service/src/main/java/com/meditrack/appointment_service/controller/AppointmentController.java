package com.meditrack.appointment_service.controller;



import com.meditrack.appointment_service.model.Appointment;
import com.meditrack.appointment_service.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentRepository repository;

    @PostMapping
    public Appointment scheduleAppointment(@RequestBody Appointment appointment) {
        return repository.save(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }
}
