package com.lyphuc.eCommerce.purchaseOrderDetail;

import com.lyphuc.eCommerce.product.Product;
import com.lyphuc.eCommerce.purchaseOrder.PurchaseOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchase_order_details")
public class PurchaseOrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_order_detail_id")
    private int purchaseOrderDetailId;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "unit_price")
    private int unitPrice;
    @Column(name = "subtotal")
    private int subtotal;

    ////////////////////////////

    public PurchaseOrderDetail(Product product, int quantity, int unitPrice, int subtotal) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

}
