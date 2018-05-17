package com.bank.service.impl;

import com.bank.constants.EntityType;
import com.bank.entity.Customer;
import com.bank.repo.CustomerRepo;
import com.bank.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bhuvneshwars on 16/5/18.
 */
@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    CustomerRepo customerRepo;


    @Override
    public Customer getCustomer(String phoneNumber) {

        Customer customer = customerRepo.findByPhoneNumber(phoneNumber);
        return customer;
    }

    @Override
    public List<Customer> getCustomerList() {

        List<Customer> customerList = customerRepo.findAll();
        return customerList;
    }

    @Override
    public void createCustomer(Customer customer) {

        customer.setServiceType(EntityType.getEntityType(customer.getServiceType()));
        customerRepo.save(customer);
    }
}
