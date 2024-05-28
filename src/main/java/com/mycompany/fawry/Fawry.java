/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fawry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author moham
 */
public class Fawry {

    private static ProductManager productManager = new ProductManager();
    private static CustomerManager customerManager = new CustomerManager();
    private static OrderManager orderManager = new OrderManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Add a new product");
            System.out.println("2. Remove a product");
            System.out.println("3. View all products");
            System.out.println("4. Add a new customer");
            System.out.println("5. Remove a customer");
            System.out.println("6. View all customers");
            System.out.println("7. Create a new order");
            System.out.println("8. View all orders");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    viewAllProducts();
                    break;
                case 4:
                    addNewCustomer();
                    break;
                case 5:
                    removeCustomer();
                    break;
                case 6:
                    viewAllCustomers();
                    break;
                case 7:
                    createNewOrder();
                    break;
                case 8:
                    viewAllOrders();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addNewProduct() {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product description: ");
        String description = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product stock quantity: ");
        int stockQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = new Product(id, name, description, price, stockQuantity);
        productManager.addProduct(product);
        System.out.println("Product added successfully.");
    }

    private static void removeProduct() {
        System.out.print("Enter product ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        productManager.removeProduct(id);
        System.out.println("Product removed successfully.");
    }

    private static void viewAllProducts() {
        productManager.viewAllProducts();
    }

    private static void addNewCustomer() {
        System.out.print("Enter customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(id, name, email, address);
        customerManager.addCustomer(customer);
        System.out.println("Customer added successfully.");
    }

    private static void removeCustomer() {
        System.out.print("Enter customer ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        customerManager.removeCustomer(id);
        System.out.println("Customer removed successfully.");
    }

    private static void viewAllCustomers() {
        customerManager.viewAllCustomers();
    }

    private static void createNewOrder() {
        System.out.print("Enter order ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter customer ID for the order: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Customer customer = customerManager.getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        List<Product> productList = new ArrayList<>();
        while (true) {
            System.out.print("Enter product ID to add to order (or -1 to finish): ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (productId == -1) break;
            Product product = productManager.getProductById(productId);
            if (product == null) {
                System.out.println("Product not found.");
                continue;
            }
            productList.add(product);
        }

        Order order = new Order(id, customer, productList);
        orderManager.addOrder(order);
        System.out.println("Order created successfully.");
    }

    private static void viewAllOrders() {
        orderManager.viewAllOrders();
    }
}
