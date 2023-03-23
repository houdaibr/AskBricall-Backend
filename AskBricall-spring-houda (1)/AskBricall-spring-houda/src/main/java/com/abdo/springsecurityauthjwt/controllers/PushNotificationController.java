package com.abdo.springsecurityauthjwt.controllers;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;

import com.abdo.springsecurityauthjwt.models.Notification;
import com.abdo.springsecurityauthjwt.services.Imp.*;

import java.util.List;

@RestController
@RequestMapping("/api/push-notifications")
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
public class PushNotificationController {

    private final PushNotificationService service;
    private final NotificationService notifservice;
    
    
    public PushNotificationController(PushNotificationService service,NotificationService notifservice) {
        this.service = service;
		this.notifservice = notifservice;
    }
    @PostMapping("")
    public Notification createNotification(@RequestBody Notification notification) {
        return notifservice.createNotificationStorage(notification);
    }

    @GetMapping("/{userID}")
    public Flux<ServerSentEvent<List<Notification>>> streamLastMessage(@PathVariable String userID) {
        return service.getNotificationsByUserToID(userID);
    }

}
