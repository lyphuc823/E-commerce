package com.lyphuc.eCommerce.order;

import com.lyphuc.eCommerce.order.OrderDto;
import com.lyphuc.eCommerce.orderDetail.OrderDetailDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> findAll();
    OrderDto findById(int id);
    void save(OrderDto orderDto);
    void deleteById(int id);
    List<OrderDetailDto> getOrderDetailList(int orderId);
}
