package com.lyphuc.eCommerce.purchaseOrderDetail;

import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetailRepository;
import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetailDto;
import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetail;
import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PurchaseOrderDetailServiceImpl implements PurchaseOrderDetailService {
    private PurchaseOrderDetailRepository purchaseOrderDetailRepository;
    @Autowired
    public PurchaseOrderDetailServiceImpl(PurchaseOrderDetailRepository purchaseOrderDetailRepository) {
        this.purchaseOrderDetailRepository = purchaseOrderDetailRepository;
    }

    @Override
    public List<PurchaseOrderDetail> findAll() {
        return purchaseOrderDetailRepository.findAll();
    }

    @Override
    public PurchaseOrderDetail findById(int id) {
        Optional<PurchaseOrderDetail> result = purchaseOrderDetailRepository.findById(id);
        PurchaseOrderDetail purchaseOrderDetail = null;
        if (result.isPresent()){
            purchaseOrderDetail = result.get();
        }else{
            throw new RuntimeException("Did not find purchase order detail id: "+id);
        }
        return purchaseOrderDetail;
    }

    @Override
    public void save(PurchaseOrderDetail purchaseOrderDetail) {
        purchaseOrderDetailRepository.save(purchaseOrderDetail);
    }

    @Override
    public void deleteById(int id) {
        purchaseOrderDetailRepository.deleteById(id);
    }
    private PurchaseOrderDetailDto mapToPurchaseOrderDetailDto(PurchaseOrderDetail purchaseOrderDetail){
        PurchaseOrderDetailDto purchaseOrderDetailDto = PurchaseOrderDetailDto.builder()
                .purchaseOrderDetailId(purchaseOrderDetail.getPurchaseOrderDetailId())
                .quantity(purchaseOrderDetail.getQuantity())
                .subtotal(purchaseOrderDetail.getSubtotal())
                .unitPrice(purchaseOrderDetail.getUnitPrice())
                .build();
        return purchaseOrderDetailDto;
    }
}
