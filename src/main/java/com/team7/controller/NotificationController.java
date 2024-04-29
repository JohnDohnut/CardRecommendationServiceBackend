package com.team7.controller;

import com.team7.service.notification.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send-slack-message")
    public String sendSlackMessage(@RequestBody String message) {
        notificationService.sendMessage(message);
        return "Message sent successfully";
    }
}



