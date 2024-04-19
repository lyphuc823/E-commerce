package com.lyphuc.eCommerce.order;

import com.lyphuc.eCommerce.orderDetail.OrderDetail;
import com.lyphuc.eCommerce.orderStatus.OrderStatus;
import com.lyphuc.eCommerce.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @Column(name = "order_date")
    @CreationTimestamp
    private LocalDateTime orderDate;
    @Column(name = "shipping_address")
    private String shippingAddress;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "payment_status")
    private String paymentStatus;
    @Column(name = "total_amount")
    private int totalAmount;
    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<OrderDetail> orderDetails;

    //////////////////////
    public Order(LocalDateTime orderDate, String shippingAddress, String paymentMethod, String paymentStatus, int totalAmount) {
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.totalAmount = totalAmount;
    }

    ///////////////////
    public void addOrderDetail(OrderDetail orderDetail){
        if(orderDetails == null){
            orderDetails = new ArrayList<>();
        }
        orderDetails.add(orderDetail);
    }
}
