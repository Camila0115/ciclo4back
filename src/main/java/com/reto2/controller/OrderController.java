package com.reto2.controller;

import java.util.List;
import java.util.Optional;

import com.reto2.model.Order;
import com.reto2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/order/")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    
    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.ObtenerOrdenes();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Order order) {
        orderService.create(order);
    }

    
    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id) {
        return orderService.getOrder(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Order order) {
        orderService.update(order);
    }
    @GetMapping("/zona/{zona}")
    public List<Order> OrderByZona(@PathVariable("zona") String zona) {
        return orderService.OrderZona(zona);
    }
}
