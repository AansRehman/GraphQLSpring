package com.grapghql.controllers;

import com.grapghql.entities.Order;
import com.grapghql.entities.User;
import com.grapghql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    create user api
    @MutationMapping
    public User createUser(@Argument String name, @Argument String password, @Argument String email, @Argument String phone){
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        return userService.createUser(user);
    }

    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @QueryMapping(name = "getUser")
    public User getUserById(@Argument int userId){
        return userService.getUserById(userId);
    }

    @MutationMapping(name = "deleteUser")
    public boolean deleteUserById(@Argument int userId){
        return userService.deleteUserById(userId);
    }

    @QueryMapping(name = "getOrderByUserId")
    public List<Order> getOrderByUserId(@Argument int userId){
        return userService.getOrdersById(userId);
    }
}
