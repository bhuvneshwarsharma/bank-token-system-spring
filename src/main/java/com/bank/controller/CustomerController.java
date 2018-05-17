package com.bank.controller;

import com.bank.entity.Customer;
import com.bank.service.impl.CustomerServiceImpl;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bhuvneshwars on 15/5/18.
 */
@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerServiceImpl customerService;

//    @ApiOperation(
//            value = "Get Customer Details",
//            nickname = "customer/{phoneNumber}"
////            produces = "application/json",
////            consumes = "application/json",
////            httpMethod = "GET"
//    )
//    @ApiResponses(value = {
//            @ApiResponse(code = 404,
//                    message = "Customer is not registered for this phoneNumber"
//            ),
//            @ApiResponse(code = 500,
//                    message = "Facing issue while fetching customer details"
//            )
//    })
//    @ApiImplicitParams(value = {
//            @ApiImplicitParam(name = "phoneNumber",
//                    paramType = "path",
//                    required = true,
//                    value = "Customer's Phone Number",
//                    dataType = "string"
//            )
//    })
    @RequestMapping(value = "/customer/{phoneNumber}", method = RequestMethod.GET, produces = "application/json")
    Customer getCustomer(@PathVariable String phoneNumber) {

        Customer customer = null;
        try {
            customer = customerService.getCustomer(phoneNumber);
        } catch(Exception e) {
            logger.error("Facing issue while fetching customer details : "+e.getMessage());
        }

        return customer;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    List<Customer> getCustomerList() {

        List<Customer> customerList = null;
        try {
            customerList = customerService.getCustomerList();
        } catch(Exception e) {
            logger.error("Facing issue while fetching customer list : "+e.getMessage());
        }
        return customerList;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    String CreateCustomer(@RequestBody Customer customer) {

        try {
            customerService.createCustomer(customer);
            return  "Customer is created successfully";

        } catch(Exception e) {
            logger.error("Facing issue while creating customer record");
            return "Facing issue while creating customer";
        }
    }
}
