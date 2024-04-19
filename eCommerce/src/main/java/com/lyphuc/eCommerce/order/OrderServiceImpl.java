package com.lyphuc.eCommerce.order;

import com.lyphuc.eCommerce.order.OrderRepository;
import com.lyphuc.eCommerce.order.OrderDto;
import com.lyphuc.eCommerce.order.Order;
import com.lyphuc.eCommerce.order.OrderService;
import com.lyphuc.eCommerce.orderDetail.OrderDetail;
import com.lyphuc.eCommerce.orderDetail.OrderDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lyphuc.eCommerce.order.OrderMapper.mapToOrder;
import static com.lyphuc.eCommerce.order.OrderMapper.mapToOrderDto;
import static com.lyphuc.eCommerce.orderDetail.OrderDetailMapper.mapToOrderDetailDto;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDto> findAll() {
        List<Order> orders = orderRepository.findAll();
        return getListOrderDto(orders);
    }

    private static List<OrderDto> getListOrderDto(List<Order> orders) {
        return orders.stream().map(order -> mapToOrderDto(order)).collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(int id) {
        Optional<Order> result = orderRepository.findById(id);
        Order order = null;
        if(result.isPresent()){
            order = result.get();
        }else{
            throw new RuntimeException("Did not find order id: "+id);
        }
        return mapToOrderDto(order);
    }

    @Override
    public void save(OrderDto orderDto) {
        Order order = mapToOrder(orderDto);
        orderRepository.save(order);
    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDetailDto> getOrderDetailList(int orderId) {
        Optional<Order> result = orderRepository.findById(orderId);
        List<OrderDetail> orderDetails = null;
        if (result.isPresent()){
            orderDetails = result.get().getOrderDetails();
        }else {
            throw new RuntimeException("can't find order id");
        }
        return getOrderDetailDtoList(orderDetails);
    }

    private static List<OrderDetailDto> getOrderDetailDtoList(List<OrderDetail> orderDetails) {
        return orderDetails.stream().map(orderDetail -> mapToOrderDetailDto(orderDetail)).collect(Collectors.toList());
    }

}
