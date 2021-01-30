package com.springMVC.SpringMVC.service;

import com.springMVC.SpringMVC.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomers();
    void saveCustomer(Customer customer);
    void deleteCustomerById(long id);
    Customer getCustomerById(long id);
}
