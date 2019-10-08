package com.vaadin.push.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

/**
 * The notification service.
 */
@Service
public class NotificationService {

    private ApnsService apnsService;

    @Autowired
    public NotificationService(
            @Value("${certificate.path}")String pathToCertificate, 
            @Value("${certificate.password}") String password) {
        
        this.apnsService = APNS.newService()
                .withCert(pathToCertificate, password)
                .withSandboxDestination()
                .build();
    }

    public void sendNotification(String token, String message) {
        String payload = APNS.newPayload().alertBody(message).sound("default").build();
        this.apnsService.push(token, payload);
    }
}
