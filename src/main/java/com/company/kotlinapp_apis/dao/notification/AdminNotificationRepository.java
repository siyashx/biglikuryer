package com.company.kotlinapp_apis.dao.notification;

import com.company.kotlinapp_apis.model.notification.AdminNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminNotificationRepository extends JpaRepository<AdminNotification, Long> {
}
