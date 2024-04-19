package com.lyphuc.eCommerce.purchaseOrderStatus;

import com.lyphuc.eCommerce.purchaseOrderStatus.PurchaseOrderStatusRepository;
import com.lyphuc.eCommerce.purchaseOrderStatus.PurchaseOrderStatus;
import com.lyphuc.eCommerce.purchaseOrderStatus.PurchaseOrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PurchaseOrderStatusServiceImpl implements PurchaseOrderStatusService {
    private PurchaseOrderStatusRepository purchaseOrderStatusRepository;
    @Autowired
    public PurchaseOrderStatusServiceImpl(PurchaseOrderStatusRepository purchaseOrderStatusRepository) {
        this.purchaseOrderStatusRepository = purchaseOrderStatusRepository;
    }

    @Override
    public List<PurchaseOrderStatus> findAll() {
        return purchaseOrderStatusRepository.findAll();
    }

    @Override
    public PurchaseOrderStatus findById(int id) {
        Optional<PurchaseOrderStatus> result = purchaseOrderStatusRepository.findById(id);
        PurchaseOrderStatus purchaseOrderStatus = null;
        if(result.isPresent()){
            purchaseOrderStatus = result.get();
        }else{
            throw new RuntimeException("Did not find purchase order status id: "+id);
        }
        return purchaseOrderStatus;
    }

    @Override
    public void save(PurchaseOrderStatus purchaseOrderStatus) {
        purchaseOrderStatusRepository.save(purchaseOrderStatus);
    }

    @Override
    public void deleteById(int id) {
        purchaseOrderStatusRepository.deleteById(id);
    }
}
