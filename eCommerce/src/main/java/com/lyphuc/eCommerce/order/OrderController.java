package com.lyphuc.eCommerce.order;

import com.lyphuc.eCommerce.orderDetail.OrderDetailDto;
import com.lyphuc.eCommerce.orderDetail.OrderDetailService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/list")
    public String getList(Model model){
        List<OrderDto> orderDtos = orderService.findAll();
        model.addAttribute("orders",orderDtos);
        return "admin/order-list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        OrderDto orderDto = new OrderDto();
        model.addAttribute("order",orderDto);
        return "admin/order-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("orderId") int id, Model model){
        OrderDto orderDto = orderService.findById(id);
        model.addAttribute("order",orderDto);
        return "admin/order-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("order")@Valid OrderDto orderDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "admin/order-form";
        }
        orderService.save(orderDto);
        return "redirect:/admin/order/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("orderId") int id){
        orderService.deleteById(id);
        return "redirect:/admin/order/list";
    }
    ////////////////

    @GetMapping("/detail/{orderId}")
    public String getListOrderDetail(@PathVariable("orderId") int orderId,Model model){
        List<OrderDetailDto> orderDetailDtos = orderService.getOrderDetailList(orderId);
        model.addAttribute("orderDetails",orderDetailDtos);
        return "admin/order-detail-list";
    }
}
