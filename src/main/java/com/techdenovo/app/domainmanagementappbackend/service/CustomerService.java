package com.techdenovo.app.domainmanagementappbackend.service;
import com.techdenovo.app.domainmanagementappbackend.model.Customer;
import com.techdenovo.app.domainmanagementappbackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer saveCustomer( Customer customer){
        if(customer!=null){
            customerRepository.save(customer);
        }
        return customer;
    }
    public Customer getCustomer(long customerId){
        Customer existingCustomer = customerRepository.findById(customerId).orElse(null);
        return existingCustomer;
    }
    public Customer updateCustomer(Customer customer){
        Customer existingCustomer= customerRepository.findById(customer.getCustomerId()).orElse(null);
//        System.out.println("existingCustomer: " +existingCustomer);
//        System.out.println(customer.getFirstName());
        if(existingCustomer!= null){
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setMobNumber(customer.getMobNumber());
            existingCustomer.setCity(customer.getCity());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setCountry(customer.getCountry());
            customerRepository.save(existingCustomer);
        }
//        System.out.println("null");
        return existingCustomer;
    }
    public void deleteCustomer(long customerId){
        Customer existingCustomer= customerRepository.findById(customerId).orElse(null);
        if (existingCustomer!=null){
            customerRepository.deleteById(existingCustomer.getCustomerId());
        }

    }
    public List<Customer> getCustomers(){
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

}
