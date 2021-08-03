package com.techdenovo.app.domainmanagementappbackend.controller;
import com.techdenovo.app.domainmanagementappbackend.model.Customer;
import com.techdenovo.app.domainmanagementappbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public Customer addCustomer( @RequestBody Customer customer) {
        if (customer != null)
            customerService.saveCustomer(customer);

        return customer;
    }
    @GetMapping("/{id}")
    public Customer showUpdateForm(@PathVariable("id") long customerId, Model model) {
        Customer customer = customerService.getCustomer(customerId);
        model.addAttribute("customer", customer);
        return customer;
    }

    @PostMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable("id") long customerId, @RequestBody Customer customer) {
        customer.setCustomerId(customerId);
        if (customer != null)
            customerService.updateCustomer(customer);
        return customer;
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") long customerId, Model model) {
        Customer customer=customerService.getCustomer(customerId);
        if(customer!=null){
            customerService.deleteCustomer(customerId);
        } else {
            System.out.println("customer is null");
        }
        return "delete customer";
    }
    @GetMapping("/list")
    public List<Customer> showCustomersList(Model model ) {
            List<Customer>customers =customerService.getCustomers();
            return customers;
        }
    }

