package com.company.kotlinapp_apis.dao.notification;

import com.company.kotlinapp_apis.model.notification.ShopNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopNotificationRepository extends JpaRepository<ShopNotification, Long> {
}
