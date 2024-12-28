package com.meditrack.notification_service.controller;



import com.meditrack.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/reminder")
    public void sendAppointmentReminder(@RequestParam String to,
                                        @RequestParam String subject,
                                        @RequestParam String message) {
        notificationService.sendReminder(to, subject, message);
    }
}
