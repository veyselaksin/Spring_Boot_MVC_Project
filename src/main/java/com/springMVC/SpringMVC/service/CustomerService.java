package com.springMVC.SpringMVC.service;

import com.springMVC.SpringMVC.model.Customer;
import com.springMVC.SpringMVC.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Customer getCustomerById(long id) {
        Optional<Customer> optional=customerRepository.findById(id);
        Customer customer=null;

        if(optional.isPresent()){
            customer=optional.get();
        }else{
            throw new RuntimeException("Customer not found for id: "+ id);
        }
        return customer;
    }
}
