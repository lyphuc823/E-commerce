package com.lyphuc.eCommerce.orderDetail;

import com.lyphuc.eCommerce.orderDetail.OrderDetailDto;
import com.lyphuc.eCommerce.orderDetail.OrderDetail;

import static com.lyphuc.eCommerce.order.OrderMapper.mapToOrder;
import static com.lyphuc.eCommerce.order.OrderMapper.mapToOrderDto;
import static com.lyphuc.eCommerce.product.ProductMapper.mapToProduct;
import static com.lyphuc.eCommerce.product.ProductMapper.mapToProductDto;

public class OrderDetailMapper {
    public static OrderDetailDto mapToOrderDetailDto(OrderDetail orderDetail){
        OrderDetailDto orderDetailDto = OrderDetailDto.builder()
                .orderDetailId(orderDetail.getOrderDetailId())
                .quantity(orderDetail.getQuantity())
                .discount(orderDetail.getDiscount())
                .subtotal(orderDetail.getSubtotal())
                .product(mapToProductDto(orderDetail.getProduct()))
                .build();
        return orderDetailDto;
    }
    public static OrderDetail mapToOrderDetail(OrderDetailDto orderDetailDto){
        OrderDetail orderDetail = OrderDetail.builder()
                .orderDetailId(orderDetailDto.getOrderDetailId())
                .quantity(orderDetailDto.getQuantity())
                .discount(orderDetailDto.getDiscount())
                .subtotal(orderDetailDto.getSubtotal())
                .product(mapToProduct(orderDetailDto.getProduct()))
                .build();
        return orderDetail;
    }
}
