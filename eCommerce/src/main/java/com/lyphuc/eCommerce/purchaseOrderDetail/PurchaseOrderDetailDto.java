package com.lyphuc.eCommerce.purchaseOrderDetail;

import com.lyphuc.eCommerce.product.Product;
import com.lyphuc.eCommerce.product.ProductDto;
import com.lyphuc.eCommerce.purchaseOrder.PurchaseOrder;
import com.lyphuc.eCommerce.purchaseOrder.PurchaseOrderDto;
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
public class PurchaseOrderDetailDto {
    private int purchaseOrderDetailId;
    private int quantity;
    private int unitPrice;
    private int subtotal;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrderDto purchaseOrder;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private ProductDto product;
}
