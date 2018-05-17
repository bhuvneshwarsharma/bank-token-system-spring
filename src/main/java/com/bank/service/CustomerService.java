package com.bank.service;

import com.bank.entity.Customer;

import java.util.List;

/**
 * Created by bhuvneshwars on 16/5/18.
 */
public interface CustomerService {

    Customer getCustomer(String phoneNumber);

    List<Customer> getCustomerList();

    void createCustomer(Customer customer);
}
