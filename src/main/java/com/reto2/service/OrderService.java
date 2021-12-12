package com.reto2.service;

import com.reto2.model.Order;
import com.reto2.model.User;
import com.reto2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> ObtenerOrdenes() {
        return orderRepository.Ordenes();
    }

    public Order create(Order order) {
        if (order.getId() == null) {
            return order;
        } else {
            return orderRepository.create(order);
        }
    }
    
    public Optional<Order> getOrder(Integer id) {
        return orderRepository.getOrder(id);
    }

    public Order update(Order neworder) {

        if (neworder.getId() != null) {
            Optional<Order> orderDb = orderRepository.getOrder(neworder.getId());
            if (!orderDb.isEmpty()) {

                if (neworder.getRegisterDay()!= null) {
                    orderDb.get().setRegisterDay(neworder.getRegisterDay());
                }

                if (neworder.getStatus()!= null) {
                    orderDb.get().setStatus(neworder.getStatus());
                }

                if (neworder.getSalesMan() != null) {
                    orderDb.get().setSalesMan(neworder.getSalesMan());
                }

                if (neworder.getProducts() != null) {
                    orderDb.get().setProducts(neworder.getProducts());
                }
                if (neworder.getQuantities() != null) {
                    orderDb.get().setQuantities(neworder.getQuantities());
                }
              //  orderDb.get().setAvailability(neworder.isAvailability());
                orderRepository.update(orderDb.get());
                return orderDb.get();
            } else {
                return neworder;
            }
        } else {
            return neworder;
        }
    }

    public List<Order> OrderZona(String Zona) {
        List<Order> ordenes = orderRepository.Ordenes();
        List<Order> NewListOrders = new ArrayList<Order>();
        for(Order item : ordenes)
        {
            User Usuario = item.getSalesMan();
            String ZonaBD = Usuario.getZone();
            if(ZonaBD.equals(Zona))
            {
                NewListOrders.add(item);
            }
        }
        return NewListOrders;
    }
    
}
