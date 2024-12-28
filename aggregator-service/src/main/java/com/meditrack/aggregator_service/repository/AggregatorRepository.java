package com.meditrack.aggregator_service.repository;


import com.meditrack.aggregator_service.model.Aggregator;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AggregatorRepository extends MongoRepository<Aggregator, String> {
}

