package com.abdo.springsecurityauthjwt.services.Imp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.abdo.springsecurityauthjwt.models.Notification;
import com.abdo.springsecurityauthjwt.repositories.NotificationRepository;

import java.util.List;

@Service
@Slf4j
public class NotificationService {

    private final NotificationRepository notifRepository;

    public NotificationService(NotificationRepository notifRepository) {
        this.notifRepository = notifRepository;
    }

    public Notification createNotificationStorage(Notification notificationStorage) {
        return notifRepository.save(notificationStorage);
    }


    public Notification getNotificationsByID(String id) {
        return notifRepository.findById(id).orElseThrow(() -> new RuntimeException("notification not found!"));
    }

    public List<Notification> getNotificationsByUserIDNotRead(String userID) {
        return notifRepository.findByUserToIdAndDeliveredFalse(userID);
    }


    public List<Notification> getNotificationsByUserID(String userID) {
        return notifRepository.findByUserToId(userID);
    }

    public Notification changeNotifStatusToRead(String notifID) {
        var notif = notifRepository.findById(notifID)
                .orElseThrow(() -> new RuntimeException("not found!"));
        notif.setRead(true);
        return notifRepository.save(notif);
    }

    public void clear() {
        notifRepository.deleteAll();
    }}