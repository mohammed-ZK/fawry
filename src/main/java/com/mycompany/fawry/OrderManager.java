/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fawry;

/**
 *
 * @author moham
 */
import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> orderList = new ArrayList<>();

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void removeOrder(int orderId) {
        orderList.removeIf(order -> order.getId() == orderId);
    }

    public void viewAllOrders() {
        orderList.forEach(System.out::println);
    }
}

