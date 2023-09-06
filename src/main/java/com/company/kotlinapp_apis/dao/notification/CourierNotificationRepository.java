package com.company.kotlinapp_apis.dao.notification;

import com.company.kotlinapp_apis.model.notification.CourierNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierNotificationRepository extends JpaRepository<CourierNotification, Long> {
}
