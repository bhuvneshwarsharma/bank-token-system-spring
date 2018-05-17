package com.bank.controller;

import com.bank.entity.Customer;
import com.bank.repo.CustomerRepo;
import com.bank.service.impl.CustomerServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bhuvneshwars on 15/5/18.
 */
@RestController
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @RequestMapping(value = "/customer/{phoneNumber}", method = RequestMethod.GET)
    Customer getCustomer(@PathVariable String phoneNumber) {

        Customer customer = null;
        try {
            customer = customerService.getCustomer(phoneNumber);
        } catch(Exception e) {}

        return customer;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    List<Customer> getCustomerList() {

        List<Customer> customerList = customerService.getCustomerList();
        return customerList;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    String CreateCustomer(@RequestBody Customer customer) {

        try {
            customerService.createCustomer(customer);
            return  "Customer is created successfully";

        } catch(Exception e) {

            return "Facing issue while creating customer";
        }
    }
}
