package com.abdo.springsecurityauthjwt.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.abdo.springsecurityauthjwt.models.Notification;
import com.abdo.springsecurityauthjwt.services.Imp.*;

import java.util.List;

@RequestMapping("/api/notification")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

public class NotificationStorageController {

    private final NotificationService notifService;


    public NotificationStorageController(NotificationService notifService) {
        this.notifService = notifService;
    }

    @GetMapping("/{userID}")
    public ResponseEntity<List<Notification>> getNotificationsByUserID(@PathVariable String userID) {
        return ResponseEntity.ok(notifService.getNotificationsByUserID(userID));
    }

    @PatchMapping("/read/{notifID}")
    public ResponseEntity changeNotifStatusToRead(@PathVariable String notifID) {
        return ResponseEntity.ok(notifService.changeNotifStatusToRead(notifID));
    }


}