package com.meditrack.aggregator_service.service;

import com.meditrack.aggregator_service.model.Aggregator;
import com.meditrack.aggregator_service.repository.AggregatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AggregatorService {

    @Autowired
    private AggregatorRepository repository;

    public Aggregator aggregateData(String reportType, String data) {
        Aggregator aggregatedData = new Aggregator();
        aggregatedData.setReportType(reportType);
        aggregatedData.setReportData(data);
        return repository.save(aggregatedData);
    }
}
