package com.reto2.repository;

import com.reto2.interfaces.OrderInterface;
import com.reto2.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    @Autowired
    private OrderInterface orderCrudRepository;

    public List<Order> Ordenes() {
        return orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(Integer id) {
        return orderCrudRepository.findById(id);
    }

    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    
    public Order update(Order order) {
       return orderCrudRepository.save(order);
    }

}
