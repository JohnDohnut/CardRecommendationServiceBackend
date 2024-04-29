package com.team7.service.notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Service
public class NotificationService {

    @Value("${slack.token}")
    private String slackToken;

    @Value("${slack.channel.id}")
    private String channelId;

    private final RestTemplate restTemplate;

    public NotificationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendMessage(String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(slackToken);

        String body = String.format("{\"channel\":\"%s\",\"text\":\"%s\"}", channelId, message);

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        String response = restTemplate.postForObject("https://slack.com/api/chat.postMessage", request, String.class);
        System.out.println("Response from Slack: " + response);
    }
}
