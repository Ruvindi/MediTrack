package com.meditrack.aggregator_service.controller;

import com.meditrack.aggregator_service.service.AggregatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AggregatorController {

    @SuppressWarnings("unused")
    @Autowired
    private AggregatorService aggregatorService;

    @GetMapping("/aggregator/metrics")
    public String getMetrics() {
        // For simplicity, this could just return the metrics stored in Redshift or in-memory
        return "Metrics aggregated successfully.";
    }
}

