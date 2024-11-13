package com.example.endterm.service;
import com.example.endterm.model.Order;
import com.example.endterm.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// import java.util.*;
// import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order>findAll(){
        return orderRepository.findAll();
    }

    // public Optional<Order> findOrderById(int id){
    //     return orderRepository.findById(id);
    // }
    public Order findById(long id){
            return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found Order !"));
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }

    public Order update(Order order){
        return orderRepository.save(order);
    }

    public void delete(long id){
        orderRepository.deleteById(id);
    }



    
}