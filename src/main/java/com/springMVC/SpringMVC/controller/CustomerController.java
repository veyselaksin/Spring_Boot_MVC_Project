package com.springMVC.SpringMVC.controller;

import com.springMVC.SpringMVC.model.Customer;
import com.springMVC.SpringMVC.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listCustomer", customerService.getAllCustomers());

        return "index";
    }
    @GetMapping("/showNewCustomerForm")
    public String showNewCustomerForm(Model model){
        Customer customer =new Customer();
        model.addAttribute("customer", customer);
        return "add_customer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Customer customer= customerService.getCustomerById(id);

        model.addAttribute("customer", customer);
        return "update_customer";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") long id){
        this.customerService.deleteCustomerById(id);

        return "redirect:/";
    }
}
