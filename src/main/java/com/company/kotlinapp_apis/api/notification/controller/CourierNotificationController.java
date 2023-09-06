package com.company.kotlinapp_apis.api.notification.controller;


import com.company.kotlinapp_apis.dto.notification.CourierNotificationDto;
import com.company.kotlinapp_apis.service.impl.notification.CourierNotificationImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courierNotification")
public class CourierNotificationController {
    
    private final CourierNotificationImpl service;

    public CourierNotificationController(CourierNotificationImpl service) {this.service = service;}

    @GetMapping
    public ResponseEntity<List<CourierNotificationDto>> getAllCourierNotification() {
        List<CourierNotificationDto> all = service.getAllCourierNotification();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{detId}")
    public ResponseEntity<CourierNotificationDto> getCourierCurrentBalanceDetById(@PathVariable("detId") Long id) {
        CourierNotificationDto det = service.getCourierNotificationById(id);
        if (det != null) {
            return ResponseEntity.ok(det);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CourierNotificationDto> saveCourierNotification(@RequestBody CourierNotificationDto dto) {
        CourierNotificationDto created = service.saveCourierNotification(dto);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{detId}")
    public ResponseEntity<String> deleteCourierNotification(@PathVariable("detId") Long id) {
        Boolean deleted = service.deleteCourierNotification(id);
        if (deleted) {
            return ResponseEntity.ok("Courier notification deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
