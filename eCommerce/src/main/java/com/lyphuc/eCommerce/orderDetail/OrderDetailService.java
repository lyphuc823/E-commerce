package com.lyphuc.eCommerce.orderDetail;

import com.lyphuc.eCommerce.orderDetail.OrderDetailDto;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailDto> findAll();
    OrderDetailDto findById(int id);
    void save(OrderDetailDto orderDetailDto);
    void deleteById(int id);
}
