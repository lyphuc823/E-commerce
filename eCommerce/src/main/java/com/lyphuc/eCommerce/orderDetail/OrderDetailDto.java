package com.lyphuc.eCommerce.orderDetail;

import com.lyphuc.eCommerce.order.Order;
import com.lyphuc.eCommerce.order.OrderDto;
import com.lyphuc.eCommerce.product.Product;
import com.lyphuc.eCommerce.product.ProductDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDto {
    private int orderDetailId;
    private int quantity;
    private int subtotal;
    private int discount;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "order_id")
    private OrderDto order;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private ProductDto product;
}
