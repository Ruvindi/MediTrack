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
    public void insertData(String sqlTemplate, String doctorName, long appointmentCount) {
        // Safely format and escape parameters
        String sql = String.format(sqlTemplate, doctorName.replace("'", "''"), appointmentCount);

        System.out.println("Executing SQL: " + sql); // Log SQL for debugging

        ExecuteStatementRequest executeRequest = ExecuteStatementRequest.builder()
                .clusterIdentifier("meditrack-redshift")  
                .database("dev")  
                .dbUser("awsuser")  
                .sql(sql)
                .build();

        ExecuteStatementResponse response = redshiftClient.executeStatement(executeRequest);

        // Check execution status
        if (response != null) {
            System.out.println("Statement executed with ID: " + response.id());
        } else {
            System.out.println("Failed to execute statement.");
        }
    }
}
