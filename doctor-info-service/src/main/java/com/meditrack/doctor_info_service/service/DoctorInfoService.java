package com.meditrack.doctor_info_service.service;

import com.meditrack.doctor_info_service.model.DoctorInfo;
import com.meditrack.doctor_info_service.repository.DoctorInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorInfoService {
    @Autowired
    private DoctorInfoRepository repository;

    public List<DoctorInfo> getAllDoctors() {
        return repository.findAll();
    }

    public DoctorInfo getDoctorById(String id) {
        return repository.findById(id).orElse(null);
    }

    public DoctorInfo addDoctor(DoctorInfo doctor) {
        return repository.save(doctor);
    }

    public DoctorInfo updateDoctor(String id, DoctorInfo doctor) {
        Optional<DoctorInfo> existingDoctor = repository.findById(id);
        if (existingDoctor.isPresent()) {
            doctor.setId(id);
            return repository.save(doctor);
        }
        return null;
    }

    public void deleteDoctor(String id) {
        repository.deleteById(id);
    }
}
