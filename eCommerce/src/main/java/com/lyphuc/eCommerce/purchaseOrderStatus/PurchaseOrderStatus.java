package com.lyphuc.eCommerce.purchaseOrderStatus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchase_order_statuses")
public class PurchaseOrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_order_status_id")
    private int purchaseOrderStatusId;
    @Column(name = "status_name")
    private String statusName;
    @Column(name = "description")
    private String description;

    //////////////////////

    public PurchaseOrderStatus(String statusName, String description) {
        this.statusName = statusName;
        this.description = description;
    }

}
