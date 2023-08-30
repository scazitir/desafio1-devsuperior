package com.scaziti.desafio1.services;

import com.scaziti.desafio1.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ShippingService shippingService;
    @Autowired
    private DiscountService discountService;

    public double total(Order order){
        return order.getBasic()
                - discountService.discount(order)
                + shippingService.shipment(order);
    }
}
