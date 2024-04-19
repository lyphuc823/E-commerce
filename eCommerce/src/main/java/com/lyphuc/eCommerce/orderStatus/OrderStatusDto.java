package com.lyphuc.eCommerce.orderStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderStatusDto {
    private int orderStatusId;
    private String statusName;
    private String description;
}
