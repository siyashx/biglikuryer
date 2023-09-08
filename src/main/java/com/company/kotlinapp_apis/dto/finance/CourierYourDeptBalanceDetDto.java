package com.company.kotlinapp_apis.dto.finance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CourierYourDeptBalanceDetDto {

    private Long id;

    private Long courierId;
    private Long shopId;
    private Integer price;
    private String date;
    private String time;
}