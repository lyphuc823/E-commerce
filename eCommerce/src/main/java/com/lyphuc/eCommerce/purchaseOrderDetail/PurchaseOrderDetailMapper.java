package com.lyphuc.eCommerce.purchaseOrderDetail;

import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetailDto;
import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetail;

import static com.lyphuc.eCommerce.product.ProductMapper.mapToProduct;
import static com.lyphuc.eCommerce.product.ProductMapper.mapToProductDto;

public class PurchaseOrderDetailMapper {
    public static PurchaseOrderDetailDto mapToPurchaseOrderDetailDto(PurchaseOrderDetail purchaseOrderDetail){
        PurchaseOrderDetailDto purchaseOrderDetailDto = PurchaseOrderDetailDto.builder()
                .purchaseOrderDetailId(purchaseOrderDetail.getPurchaseOrderDetailId())
                .unitPrice(purchaseOrderDetail.getUnitPrice())
                .subtotal(purchaseOrderDetail.getSubtotal())
                .quantity(purchaseOrderDetail.getQuantity())
                .product(mapToProductDto(purchaseOrderDetail.getProduct()))
                .build();
        return purchaseOrderDetailDto;
    }
    public static PurchaseOrderDetail mapToPurchaseOrderDetail(PurchaseOrderDetailDto purchaseOrderDetailDto){
        PurchaseOrderDetail purchaseOrderDetail =PurchaseOrderDetail.builder()
                .purchaseOrderDetailId(purchaseOrderDetailDto.getPurchaseOrderDetailId())
                .unitPrice(purchaseOrderDetailDto.getUnitPrice())
                .subtotal(purchaseOrderDetailDto.getSubtotal())
                .quantity(purchaseOrderDetailDto.getQuantity())
                .product(mapToProduct(purchaseOrderDetailDto.getProduct()))
                .build();
        return purchaseOrderDetail;
    }
}
