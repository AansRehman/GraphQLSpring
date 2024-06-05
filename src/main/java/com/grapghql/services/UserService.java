package com.grapghql.services;

import com.grapghql.entities.Order;
import com.grapghql.entities.User;
import com.grapghql.helper.ExceptionHelper;
import com.grapghql.repositries.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(int id) {
        User user = userRepo.findById(id).orElseThrow(ExceptionHelper::throwResouceNotFoundException);
        return user;
    }
    public boolean deleteUserById(int id) {
        User user = userRepo.findById(id).orElseThrow(ExceptionHelper::throwResouceNotFoundException);
        userRepo.delete(user);
        return true;
    }
    public boolean updateUser(User user) {
        User user1 = userRepo.findById(user.getUserId()).orElseThrow(ExceptionHelper::throwResouceNotFoundException);
        System.out.printf(String.valueOf(user1));
        user1 = user;
        userRepo.save(user1);
        return true;
    }

    public List<Order> getOrdersById(int userId){
        User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResouceNotFoundException);
        List<Order> orders = user.getOrders();
        return orders;
    }
}
