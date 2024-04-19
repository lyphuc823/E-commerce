package com.lyphuc.eCommerce.purchaseOrder;

import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetail;
import com.lyphuc.eCommerce.purchaseOrderStatus.PurchaseOrderStatus;
import com.lyphuc.eCommerce.provider.Provider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_order_id")
    private int purchaseOrderId;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "provider_id")
    private Provider provider;
    @Column(name = "order_date")
    @CreationTimestamp
    private LocalDateTime orderDate;
    @Column(name = "shipping_address")
    private String shippingAddress;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "purchase_order_status_id")
    private PurchaseOrderStatus purchaseOrderStatus;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "payment_status")
    private String paymentStatus;
    @Column(name = "total_amount")
    private String totalAmount;
    @OneToMany(mappedBy = "purchaseOrder",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<PurchaseOrderDetail> purchaseOrderDetails;

    ////////////////////////
    public PurchaseOrder(LocalDateTime orderDate, String shippingAddress, String paymentMethod, String paymentStatus, String totalAmount) {
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.totalAmount = totalAmount;
    }

}

