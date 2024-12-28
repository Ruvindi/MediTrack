package com.meditrack.aggregator_service.config;

import software.amazon.awssdk.services.redshift.RedshiftClient;
import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.redshift.model.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedshiftConfig {

    @Bean
    public RedshiftClient redshiftClient() {
        return RedshiftClient.builder()
                .region(Region.US_EAST_1) // Change region as necessary
                .build();
    }
}
