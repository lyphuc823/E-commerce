package com.lyphuc.eCommerce.purchaseOrder;

import com.lyphuc.eCommerce.purchaseOrderStatus.PurchaseOrderStatus;
import com.lyphuc.eCommerce.provider.ProviderDto;
import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetailDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseOrderDto {
    private int purchaseOrderId;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime orderDate;
    private String shippingAddress;
    private String paymentMethod;
    private String paymentStatus;
    private String totalAmount;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "provider_id")
    private ProviderDto provider;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "purchase_order_status_id")
    private PurchaseOrderStatus purchaseOrderStatus;
    @OneToMany(mappedBy = "purchaseOrder",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<PurchaseOrderDetailDto> purchaseOrderDetails;
}
