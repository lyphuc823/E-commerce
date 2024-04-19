package com.lyphuc.eCommerce.purchaseOrder;

import com.lyphuc.eCommerce.purchaseOrder.PurchaseOrderDto;
import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetail;
import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetailDto;

import java.util.List;

public interface PurchaseOrderService {
    List<PurchaseOrderDto> findAll();
    PurchaseOrderDto findById(int id);
    void save(PurchaseOrderDto purchaseOrderDto);
    void deleteById(int id);
    List<PurchaseOrderDetailDto> getPurchaseOrderDetailList(int purchaseOrderId);
}
