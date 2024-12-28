package com.meditrack.aggregator_service.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Aggregator {
    @Id
    private String id;
    private String reportType;
    private String reportData;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getReportType() { return reportType; }
    public void setReportType(String reportType) { this.reportType = reportType; }

    public String getReportData() { return reportData; }
    public void setReportData(String reportData) { this.reportData = reportData; }
}
