package com.meditrack.notification_service.service;


import com.meditrack.notification_service.model.Notification;
import com.meditrack.notification_service.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    private final SesClient sesClient;

    public NotificationService() {
        this.sesClient = SesClient.builder()
                .region(Region.US_EAST_1) // Change to your SES region
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();
    }

    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }

    public Notification sendNotification(Notification notification) {
        try {
            if ("email".equalsIgnoreCase(notification.getType())) {
                sendEmail(notification);
            }
            notification.setSent(true);
        } catch (Exception e) {
            notification.setSent(false);
        }
        return repository.save(notification);
    }

    private void sendEmail(Notification notification) {
        try {
            SendEmailRequest emailRequest = SendEmailRequest.builder()
                    .destination(Destination.builder()
                            .toAddresses(notification.getRecipient())
                            .build())
                    .message(Message.builder()
                            .subject(Content.builder()
                                    .data("Notification")
                                    .build())
                            .body(Body.builder()
                                    .text(Content.builder()
                                            .data(notification.getMessage())
                                            .build())
                                    .build())
                            .build())
                    .source("<YOUR_VERIFIED_EMAIL>") // Replace with a verified SES email
                    .build();

            sesClient.sendEmail(emailRequest);
        } catch (SesException e) {
            throw new RuntimeException("Failed to send email via SES: " + e.getMessage());
        }
    }
}
