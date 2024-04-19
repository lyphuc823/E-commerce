package com.lyphuc.eCommerce.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderKey implements Serializable {
    private int orderId;
    private int orderDate;

    public OrderKey(int orderId, int orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderKey orderKey1 = (OrderKey) o;
        return orderId == orderKey1.orderId && orderDate == orderKey1.orderDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderDate);
    }
}
