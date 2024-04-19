package com.lyphuc.eCommerce.purchaseOrder;

import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetail;
import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetailDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/purchase-order")
public class PurchaseOrderController {
    private PurchaseOrderService purchaseOrderService;

    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @GetMapping("/list")
    public String getList(Model model){
        List<PurchaseOrderDto> purchaseOrderDtos = purchaseOrderService.findAll();
        model.addAttribute("purchaseOrders",purchaseOrderDtos);
        return "admin/purchase-order-list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        PurchaseOrderDto purchaseOrderDto = new PurchaseOrderDto();
        model.addAttribute("purchaseOrder",purchaseOrderDto);
        return "admin/purchase-order-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("purchaseOrderId")int id, Model model){
        PurchaseOrderDto purchaseOrderDto = purchaseOrderService.findById(id);
        model.addAttribute("purchaseOrder",purchaseOrderDto);
        return "admin/purchase-order-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("purchaseOrder") @Valid PurchaseOrderDto purchaseOrderDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "admin/purchase-order-form";
        }
        purchaseOrderService.save(purchaseOrderDto);
        return "redirect:/admin/purchase-order/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("purchaseOrderId") int id){
        purchaseOrderService.deleteById(id);
        return "redirect:/admin/purchase-order/list";
    }
    //////////
    @GetMapping("/detail/{purchaseOrderId}")
    public String getPurchaseOrderDetailList(@PathVariable("purchaseOrderId") int id,Model model){
        List<PurchaseOrderDetailDto> purchaseOrderDetails = purchaseOrderService.getPurchaseOrderDetailList(id);
        model.addAttribute("purchaseOrderDetails",purchaseOrderDetails);
        return "admin/purchase-order-detail-list";
    }
}
