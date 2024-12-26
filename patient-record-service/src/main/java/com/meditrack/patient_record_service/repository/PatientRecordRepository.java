package com.meditrack.patient_record_service.repository;


import com.meditrack.patient_record_service.model.PatientRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRecordRepository extends MongoRepository<PatientRecord, String> {
}
