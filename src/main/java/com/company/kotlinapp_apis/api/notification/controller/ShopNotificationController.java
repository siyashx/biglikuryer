package com.company.kotlinapp_apis.api.notification.controller;


import com.company.kotlinapp_apis.dto.notification.ShopNotificationDto;
import com.company.kotlinapp_apis.service.impl.notification.ShopNotificationImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shopNotification")
public class ShopNotificationController {

    private final ShopNotificationImpl service;

    public ShopNotificationController(ShopNotificationImpl service) {this.service = service;}

    @GetMapping
    public ResponseEntity<List<ShopNotificationDto>> getAllShopNotification() {
        List<ShopNotificationDto> all = service.getAllShopNotification();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{detId}")
    public ResponseEntity<ShopNotificationDto> getShopCurrentBalanceDetById(@PathVariable("detId") Long id) {
        ShopNotificationDto det = service.getShopNotificationById(id);
        if (det != null) {
            return ResponseEntity.ok(det);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ShopNotificationDto> saveShopNotification(@RequestBody ShopNotificationDto dto) {
        ShopNotificationDto created = service.saveShopNotification(dto);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{detId}")
    public ResponseEntity<String> deleteShopNotification(@PathVariable("detId") Long id) {
        Boolean deleted = service.deleteShopNotification(id);
        if (deleted) {
            return ResponseEntity.ok("Shop notification deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
