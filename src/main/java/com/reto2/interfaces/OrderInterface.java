package com.reto2.interfaces;
import com.reto2.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderInterface extends MongoRepository<Order, Integer> {

}
