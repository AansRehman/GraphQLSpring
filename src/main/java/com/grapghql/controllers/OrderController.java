package com.grapghql.controllers;

import com.grapghql.entities.Order;
import com.grapghql.entities.User;
import com.grapghql.services.OrderService;
import com.grapghql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class OrderController {
    private OrderService orderService;
    private UserService userService;

    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @MutationMapping
    public Order createOrder(@Argument String orderDetail, @Argument String address, @Argument int price, @Argument int userId){

        User user = userService.getUserById(userId);

        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);

        Order order1 = orderService.createOrde(order);
        return order1;
    }
    @QueryMapping(name = "getOrders")
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    @QueryMapping(name = "getOrder")
    public Order getOrder(@Argument int orderId){
        return orderService.getOrder(orderId);
    }

    @MutationMapping
    public boolean deleteOrder(@Argument int orderId){
        return orderService.deleteOrder(orderId);
    }


}
