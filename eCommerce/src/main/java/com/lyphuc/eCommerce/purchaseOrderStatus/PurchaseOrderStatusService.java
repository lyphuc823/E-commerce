package com.lyphuc.eCommerce.purchaseOrderStatus;

import com.lyphuc.eCommerce.purchaseOrderStatus.PurchaseOrderStatus;

import java.util.List;

public interface PurchaseOrderStatusService {
    List<PurchaseOrderStatus> findAll();
    PurchaseOrderStatus findById(int id);
    void save(PurchaseOrderStatus purchaseOrderStatus);
    void deleteById(int id);
}
