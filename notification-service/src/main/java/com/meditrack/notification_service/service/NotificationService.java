package com.meditrack.notification_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

@Service
public class NotificationService {

    @Value("${aws.ses.accessKey}")
    private String accessKey;

    @Value("${aws.ses.secretKey}")
    private String secretKey;

    @Value("${aws.ses.region}")
    private String region;

    @Value("${aws.ses.fromEmail}")
    private String fromEmail;

    public void sendReminder(String to, String subject, String messageBody) {
        SesClient sesClient = SesClient.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKey, secretKey)))
                .build();

        SendEmailRequest emailRequest = SendEmailRequest.builder()
                .destination(Destination.builder()
                        .toAddresses(to)
                        .build())
                .message(Message.builder()
                        .subject(Content.builder()
                                .data(subject)
                                .charset("UTF-8")
                                .build())
                        .body(Body.builder()
                                .text(Content.builder()
                                        .data(messageBody)
                                        .charset("UTF-8")
                                        .build())
                                .build())
                        .build())
                .source(fromEmail)
                .build();

        sesClient.sendEmail(emailRequest);
        sesClient.close();
    }
}
