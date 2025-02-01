package com.carservice.coreservice.controller;

import com.carservice.coreservice.service.ServiceOrder;
import com.carservice.coreservice.model.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-orders")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @GetMapping
    public List<ServiceOrder> getAllServiceOrders() {
        return serviceOrderService.getAllServiceOrders();
    }

    @GetMapping("/{id}")
    public ServiceOrder getServiceOrderById(@PathVariable Long id) {
        return serviceOrderService.getServiceOrderById(id).orElseThrow(() -> new RuntimeException("Заказ не найден"));
    }

    @PostMapping
    public ServiceOrder createServiceOrder(@RequestBody ServiceOrder serviceOrder) {
        return serviceOrderService.createServiceOrder(serviceOrder);
    }

    @PutMapping("/{id}")
    public ServiceOrder updateServiceOrder(@PathVariable Long id, @RequestBody ServiceOrder serviceOrderDetails) {
        return serviceOrderService.updateServiceOrder(id, serviceOrderDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteServiceOrder(@PathVariable Long id) {
        serviceOrderService.deleteServiceOrder(id);
    }
}