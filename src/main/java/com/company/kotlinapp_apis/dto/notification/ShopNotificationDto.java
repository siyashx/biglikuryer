package com.company.kotlinapp_apis.dto.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ShopNotificationDto {

    private Long id;

    private Long userId;

    private String text;
}
