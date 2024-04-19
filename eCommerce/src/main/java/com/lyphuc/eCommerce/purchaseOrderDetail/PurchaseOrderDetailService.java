package com.lyphuc.eCommerce.purchaseOrderDetail;


import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetail;

import java.util.List;

public interface PurchaseOrderDetailService {
    List<PurchaseOrderDetail> findAll();
    PurchaseOrderDetail findById(int id);
    void save(PurchaseOrderDetail purchaseOrderDetail);
    void deleteById(int id);
}
