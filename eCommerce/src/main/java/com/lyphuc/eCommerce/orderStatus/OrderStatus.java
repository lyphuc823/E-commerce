package com.lyphuc.eCommerce.orderStatus;

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
@Table(name = "order_statuses")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_status_id")
    private int orderStatusId;
    @Column(name = "status_name")
    private String statusName;
    @Column(name = "description")
    private String description;

    //////////////////////////

    public OrderStatus(String statusName, String description) {
        this.statusName = statusName;
        this.description = description;
    }

}
