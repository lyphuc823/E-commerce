package com.lyphuc.eCommerce.purchaseOrder;

import com.lyphuc.eCommerce.purchaseOrder.PurchaseOrderDto;
import com.lyphuc.eCommerce.purchaseOrder.PurchaseOrder;
import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetailMapper;

import java.util.stream.Collectors;

import static com.lyphuc.eCommerce.provider.ProviderMapper.mapToProvider;
import static com.lyphuc.eCommerce.provider.ProviderMapper.mapToProviderDto;

public class PurchaseOrderMapper {
    public static PurchaseOrderDto mapToPurchaseOrderDto(PurchaseOrder purchaseOrder){
        PurchaseOrderDto purchaseOrderDto = PurchaseOrderDto.builder()
                .purchaseOrderId(purchaseOrder.getPurchaseOrderId())
                .totalAmount(purchaseOrder.getTotalAmount())
                .shippingAddress(purchaseOrder.getShippingAddress())
                .orderDate(purchaseOrder.getOrderDate())
                .paymentStatus(purchaseOrder.getPaymentStatus())
                .paymentMethod(purchaseOrder.getPaymentMethod())
                .provider(mapToProviderDto(purchaseOrder.getProvider()))
                .purchaseOrderStatus(purchaseOrder.getPurchaseOrderStatus())
                .purchaseOrderDetails(purchaseOrder.getPurchaseOrderDetails().stream().map(PurchaseOrderDetailMapper::mapToPurchaseOrderDetailDto).collect(Collectors.toList()))
                .build();
        return purchaseOrderDto;
    }
    public static PurchaseOrder mapToPurchaseOrder(PurchaseOrderDto purchaseOrderDto){
        PurchaseOrder purchaseOrder = PurchaseOrder.builder()
                .purchaseOrderId(purchaseOrderDto.getPurchaseOrderId())
                .totalAmount(purchaseOrderDto.getTotalAmount())
                .shippingAddress(purchaseOrderDto.getShippingAddress())
                .orderDate(purchaseOrderDto.getOrderDate())
                .paymentStatus(purchaseOrderDto.getPaymentStatus())
                .paymentMethod(purchaseOrderDto.getPaymentMethod())
                .provider(mapToProvider(purchaseOrderDto.getProvider()))
                .purchaseOrderStatus(purchaseOrderDto.getPurchaseOrderStatus())
                .purchaseOrderDetails(purchaseOrderDto.getPurchaseOrderDetails().stream().map(PurchaseOrderDetailMapper::mapToPurchaseOrderDetail).collect(Collectors.toList()))
                .build();
        return purchaseOrder;
    }
}
