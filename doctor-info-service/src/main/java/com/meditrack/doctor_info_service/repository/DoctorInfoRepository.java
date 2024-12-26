package com.meditrack.doctor_info_service.repository;

import com.meditrack.doctor_info_service.model.DoctorInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorInfoRepository extends MongoRepository<DoctorInfo, String> {
}
