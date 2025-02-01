package com.carservice.coreservice.model;

import com.carservice.coreservice.service.ServiceOrder;
import com.carservice.coreservice.repository.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public List<ServiceOrder> getAllServiceOrders() {
        return serviceOrderRepository.findAll();
    }

    public Optional<ServiceOrder> getServiceOrderById(Long id) {
        return serviceOrderRepository.findById(id);
    }

    public ServiceOrder createServiceOrder(ServiceOrder serviceOrder) {
        serviceOrder.setOrderDate(LocalDate.now());
        serviceOrder.setStatus("В ожидании");
        return serviceOrderRepository.save(serviceOrder);
    }

    public ServiceOrder updateServiceOrder(Long id, ServiceOrder serviceOrderDetails) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("Заказ не найден"));
        serviceOrder.setClientName(serviceOrderDetails.getClientName());
        serviceOrder.setCarModel(serviceOrderDetails.getCarModel());
        serviceOrder.setDescription(serviceOrderDetails.getDescription());
        serviceOrder.setStatus(serviceOrderDetails.getStatus());
        return serviceOrderRepository.save(serviceOrder);
    }

    public void deleteServiceOrder(Long id) {
        serviceOrderRepository.deleteById(id);
    }
}