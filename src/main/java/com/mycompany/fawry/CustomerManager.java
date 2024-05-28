package com.mycompany.fawry;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author moham
 */
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customerList = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void removeCustomer(int customerId) {
        customerList.removeIf(customer -> customer.getId() == customerId);
    }

    public void viewAllCustomers() {
        customerList.forEach(System.out::println);
    }
    public Customer getCustomerById(int customerId) {
        for (Customer customer : customerList) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }
}
