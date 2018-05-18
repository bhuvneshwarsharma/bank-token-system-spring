package com.bank.service.impl;

import com.bank.constants.ServiceType;
import com.bank.entity.Customer;
import com.bank.repo.CustomerRepo;
import com.bank.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhuvneshwars on 17/5/18.
 */
@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {

    @TestConfiguration
    static class CustomerServiceImplTestContextConfiguration {

        @Bean
        public CustomerService customerService() {
            return new CustomerServiceImpl();
        }
    }

    @Autowired
    private CustomerService customerService;
    @MockBean
    private CustomerRepo customerRepo;

    @Before
    public void setUp() {
        Customer customer1 = new Customer("Bhuvi", "7897952579", "Hyderabad", ServiceType.DEPOSIT.toString());
        Mockito.when(customerRepo.findByPhoneNumber(customer1.getPhoneNumber()))
                .thenReturn(customer1);

        Customer customer2 = new Customer("Alex", "6782342434", "Hyderabad", ServiceType.DEPOSIT.toString());
        List<Customer> customerList = new ArrayList<Customer>(){{add(customer1); add(customer2);}};

        Mockito.when(customerRepo.findAll())
                .thenReturn(customerList);
    }

    @Test
    public void whenValidPhoneNumber_thenCustomerShouldBeFound() {
        String phoneNumber = "7897952579";
        Customer found = customerService.getCustomer(phoneNumber);

        assert found.getPhoneNumber().equalsIgnoreCase(phoneNumber);
    }

    @Test
    public void whenFetchAllCustomers_thenCustomerListShouldBeFound() {
        List<Customer> customerList = customerService.getCustomerList();

        assert customerList.size() == 2;
        assert customerList.get(0).getName().equalsIgnoreCase("Bhuvi");
        assert customerList.get(1).getName().equalsIgnoreCase("Alex");
    }

}
