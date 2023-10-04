package com.company.kotlinapp_apis.model.finance;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourierYourDeptBalanceDet {

    @Id
    private Long id;

    private Long courierId;
    private Long shopId;
    private Double price;
    private String date;
    private String time;
}
