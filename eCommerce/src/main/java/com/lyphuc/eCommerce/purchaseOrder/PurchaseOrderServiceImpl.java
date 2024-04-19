package com.lyphuc.eCommerce.purchaseOrder;

import com.lyphuc.eCommerce.purchaseOrder.PurchaseOrderRepository;
import com.lyphuc.eCommerce.purchaseOrder.PurchaseOrderDto;
import com.lyphuc.eCommerce.purchaseOrder.PurchaseOrder;
import com.lyphuc.eCommerce.purchaseOrder.PurchaseOrderService;
import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetail;
import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lyphuc.eCommerce.purchaseOrder.PurchaseOrderMapper.mapToPurchaseOrder;
import static com.lyphuc.eCommerce.purchaseOrder.PurchaseOrderMapper.mapToPurchaseOrderDto;
import static com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetailMapper.mapToPurchaseOrderDetailDto;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    private PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    @Override
    public List<PurchaseOrderDto> findAll() {
        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.findAll();
        return getPurchaseOrderDtoList(purchaseOrders);
    }

    private List<PurchaseOrderDto> getPurchaseOrderDtoList(List<PurchaseOrder> purchaseOrders) {
        return purchaseOrders.stream().map(purchaseOrder -> mapToPurchaseOrderDto(purchaseOrder)).collect(Collectors.toList());
    }

    @Override
    public PurchaseOrderDto findById(int id) {
        Optional<PurchaseOrder> result = purchaseOrderRepository.findById(id);
        PurchaseOrder purchaseOrder = null;
        if(result.isPresent()){
            purchaseOrder = result.get();
        }else {
            throw new RuntimeException("Did not find purchase order id: "+id);
        }
        return mapToPurchaseOrderDto(purchaseOrder);
    }

    @Override
    public void save(PurchaseOrderDto purchaseOrderDto) {
        PurchaseOrder purchaseOrder = mapToPurchaseOrder(purchaseOrderDto);
        purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public void deleteById(int id) {
        purchaseOrderRepository.deleteById(id);
    }

    @Override
    public List<PurchaseOrderDetailDto> getPurchaseOrderDetailList(int purchaseOrderId) {
        Optional<PurchaseOrder> result = purchaseOrderRepository.findById(purchaseOrderId);
        List<PurchaseOrderDetail> purchaseOrderDetail = null;
        if (result.isPresent()){
            purchaseOrderDetail = result.get().getPurchaseOrderDetails();
        }else {
            throw new RuntimeException("can not find purchase order id");
        }
        return getPurchaseOrderDetailDtoList(purchaseOrderDetail);
    }

    private static List<PurchaseOrderDetailDto> getPurchaseOrderDetailDtoList(List<PurchaseOrderDetail> purchaseOrderDetail) {
        return purchaseOrderDetail.stream().map(purchaseOrderDetail1 -> mapToPurchaseOrderDetailDto(purchaseOrderDetail1)).collect(Collectors.toList());
    }

}
