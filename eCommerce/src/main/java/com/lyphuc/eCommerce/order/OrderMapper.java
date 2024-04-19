package com.lyphuc.eCommerce.order;

import com.lyphuc.eCommerce.order.OrderDto;
import com.lyphuc.eCommerce.order.Order;

import java.util.stream.Collectors;

import static com.lyphuc.eCommerce.orderDetail.OrderDetailMapper.mapToOrderDetail;
import static com.lyphuc.eCommerce.orderDetail.OrderDetailMapper.mapToOrderDetailDto;

public class OrderMapper {
    public static OrderDto mapToOrderDto(Order order){
        OrderDto orderDto = OrderDto.builder()
                .orderId(order.getOrderId())
                .user(order.getUser())
                .totalAmount(order.getTotalAmount())
                .shippingAddress(order.getShippingAddress())
                .orderDate(order.getOrderDate())
                .paymentStatus(order.getPaymentStatus())
                .paymentMethod(order.getPaymentMethod())
                .orderStatus(order.getOrderStatus())
                .orderDetails(order.getOrderDetails().stream().map(orderDetail -> mapToOrderDetailDto(orderDetail)).collect(Collectors.toList()))
                .build();
        return orderDto;
    }
    public static Order mapToOrder(OrderDto orderDto){
        Order order = Order.builder()
                .orderId(orderDto.getOrderId())
                .user(orderDto.getUser())
                .totalAmount(orderDto.getTotalAmount())
                .shippingAddress(orderDto.getShippingAddress())
                .orderDate(orderDto.getOrderDate())
                .paymentStatus(orderDto.getPaymentStatus())
                .paymentMethod(orderDto.getPaymentMethod())
                .orderStatus(orderDto.getOrderStatus())
                .orderDetails(orderDto.getOrderDetails().stream().map(orderDetailDto -> mapToOrderDetail(orderDetailDto)).collect(Collectors.toList()))
                .build();
        return order;
    }
}
