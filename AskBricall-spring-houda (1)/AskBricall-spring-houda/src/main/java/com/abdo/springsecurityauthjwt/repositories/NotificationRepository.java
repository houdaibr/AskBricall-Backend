package com.abdo.springsecurityauthjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abdo.springsecurityauthjwt.models.Notification;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, String> {

    Optional<Notification> findById(String id);

    List<Notification> findByUserToId(String id);
    


    List<Notification> findByUserToIdAndDeliveredFalse(String id);


}