package com.lyphuc.eCommerce.orderDetail;

import com.lyphuc.eCommerce.orderDetail.OrderDetailRepository;
import com.lyphuc.eCommerce.orderDetail.OrderDetailDto;
import com.lyphuc.eCommerce.orderDetail.OrderDetail;
import com.lyphuc.eCommerce.orderDetail.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lyphuc.eCommerce.orderDetail.OrderDetailMapper.mapToOrderDetail;
import static com.lyphuc.eCommerce.orderDetail.OrderDetailMapper.mapToOrderDetailDto;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<OrderDetailDto> findAll() {
        List<OrderDetail> orderDetails = orderDetailRepository.findAll();
        return getListOrderDetailDto(orderDetails);
    }

    private List<OrderDetailDto> getListOrderDetailDto(List<OrderDetail> orderDetails) {
        return orderDetails.stream().map(orderDetail -> mapToOrderDetailDto(orderDetail)).collect(Collectors.toList());
    }

    @Override
    public OrderDetailDto findById(int id) {
        Optional<OrderDetail> result = orderDetailRepository.findById(id);
        OrderDetail orderDetail = null;
        if(result.isPresent()){
            orderDetail = result.get();
        }else{
            throw new RuntimeException("Did not find order detail id: "+id);
        }
        return mapToOrderDetailDto(orderDetail);
    }

    @Override
    public void save(OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = mapToOrderDetail(orderDetailDto);
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public void deleteById(int id) {
        orderDetailRepository.deleteById(id);
    }

}
