package com.lyphuc.eCommerce.purchaseOrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseOrderStatusDto {
    private int purchaseOrderStatusId;
    private String statusName;
    private String description;
}
