package com.lyphuc.eCommerce.orderStatus;

import com.lyphuc.eCommerce.orderStatus.OrderStatus;

import java.util.List;

public interface OrderStatusService {
    List<OrderStatus> findAll();
    OrderStatus findById(int id);
    void save(OrderStatus orderStatus);
    void deleteById(int id);
}
