package com.company.kotlinapp_apis.dto.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AdminNotificationDto {

    private Long id;

    private String userId;

    private String text;

}
