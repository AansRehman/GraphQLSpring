package com.grapghql.services;

import com.grapghql.entities.Order;
import com.grapghql.helper.ExceptionHelper;
import com.grapghql.repositries.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepo orderRepo;
    public OrderService(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }

    //create order
    public Order createOrde(Order order){
        return orderRepo.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order getOrder(int orderId){
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResouceNotFoundException);
        return order;
    }

    public boolean deleteOrder(int orderId){
        Order order = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResouceNotFoundException);
        orderRepo.delete(order);
        return true;
    }

}
