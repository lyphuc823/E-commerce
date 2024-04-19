package com.lyphuc.eCommerce.orderStatus;

import com.lyphuc.eCommerce.orderStatus.OrderStatusRepository;
import com.lyphuc.eCommerce.orderStatus.OrderStatus;
import com.lyphuc.eCommerce.orderStatus.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    private OrderStatusRepository orderStatusRepository;
    @Autowired
    public OrderStatusServiceImpl(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @Override
    public List<OrderStatus> findAll() {
        return orderStatusRepository.findAll();
    }

    @Override
    public OrderStatus findById(int id) {
        Optional<OrderStatus> result = orderStatusRepository.findById(id);
        OrderStatus orderStatus = null;
        if(result.isPresent()){
            orderStatus = result.get();
        }else{
            throw new RuntimeException("Did not find order status id: "+id);
        }
        return orderStatus;
    }

    @Override
    public void save(OrderStatus orderStatus) {
        orderStatusRepository.save(orderStatus);
    }

    @Override
    public void deleteById(int id) {
        orderStatusRepository.deleteById(id);
    }
}
