package com.meditrack.aggregator_service.service;

import software.amazon.awssdk.services.redshiftdata.RedshiftDataClient;
import software.amazon.awssdk.services.redshiftdata.model.ExecuteStatementRequest;
import software.amazon.awssdk.services.redshiftdata.model.ExecuteStatementResponse;
import software.amazon.awssdk.services.redshiftdata.model.SqlParameter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedshiftService {

    private final RedshiftDataClient redshiftClient;

    public RedshiftService() {
        this.redshiftClient = RedshiftDataClient.create();  // Ensure you have AWS credentials configured
    }

    // Method to insert data into Redshift
    public void insertData(String sql, String doctorName, long appointmentCount) {
        // Prepare parameters
        SqlParameter doctorNameParam = SqlParameter.builder()
                .name("doctor_name")  // Make sure your SQL query has this placeholder
                .value(doctorName)
                .build();

        SqlParameter appointmentCountParam = SqlParameter.builder()
                .name("appointment_count")
                .value(String.valueOf(appointmentCount))
                .build();

        // Execute statement request
        ExecuteStatementRequest executeRequest = ExecuteStatementRequest.builder()
                .clusterIdentifier("meditrack-redshift")
                .database("dev")
                .sql(sql)  // Make sure your SQL has placeholders for parameters
                .parameters(List.of(doctorNameParam, appointmentCountParam))  // Pass parameters as a list
                .build();

        // Execute the statement
        ExecuteStatementResponse response = redshiftClient.executeStatement(executeRequest);

        // Check execution status
        if (response != null) {
            // You can check the status of the statement execution using the statement ID
            String statementId = response.id();
            System.out.println("Statement executed with ID: " + statementId);
        } else {
            System.out.println("Failed to execute statement.");
        }
    }
}
