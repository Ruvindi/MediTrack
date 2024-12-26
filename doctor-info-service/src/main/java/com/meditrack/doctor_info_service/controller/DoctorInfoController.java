package com.meditrack.doctor_info_service.controller;

import com.meditrack.doctor_info_service.model.DoctorInfo;
import com.meditrack.doctor_info_service.service.DoctorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorInfoController {
    @Autowired
    private DoctorInfoService service;

    @GetMapping
    public ResponseEntity<List<DoctorInfo>> getAllDoctors() {
        return ResponseEntity.ok(service.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorInfo> getDoctorById(@PathVariable String id) {
        DoctorInfo doctor = service.getDoctorById(id);
        return doctor != null ? ResponseEntity.ok(doctor) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DoctorInfo> addDoctor(@RequestBody DoctorInfo doctor) {
        return ResponseEntity.ok(service.addDoctor(doctor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorInfo> updateDoctor(@PathVariable String id, @RequestBody DoctorInfo doctor) {
        DoctorInfo updatedDoctor = service.updateDoctor(id, doctor);
        return updatedDoctor != null ? ResponseEntity.ok(updatedDoctor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable String id) {
        service.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
