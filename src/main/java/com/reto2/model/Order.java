package com.reto2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "orders")

@Data

@NoArgsConstructor

@AllArgsConstructor

public class Order {

public static String PENDING = "Pendiente";

public static String APROVED = "Aprobada";

public static String REJECTED = "Rechazada";

@Id

private Integer id;

private Date registerDay;

private String status;

private User salesMan;

private Map<Integer, Gadget> products;

private Map<Integer, Integer> quantities;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegisterDay() {
        return this.registerDay;
    }

    public void setRegisterDay(Date registerDay) {
        this.registerDay = registerDay;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getSalesMan() {
        return this.salesMan;
    }

    public void setSalesMan(User salesMan) {
        this.salesMan = salesMan;
    }

    public Map<Integer,Gadget> getProducts() {
        return this.products;
    }

    public void setProducts(Map<Integer,Gadget> products) {
        this.products = products;
    }

    public Map<Integer,Integer> getQuantities() {
        return this.quantities;
    }

    public void setQuantities(Map<Integer,Integer> quantities) {
        this.quantities = quantities;
    }

}

