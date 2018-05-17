package com.bank.controller;

import com.bank.service.impl.TestDataImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bhuvneshwars on 15/5/18.
 */
@RestController
public class TestDataController {

    @Autowired
    TestDataImpl testDataImpl;

    @RequestMapping("/dummyData")
    public String createBankDummyData() {

        try{
            boolean created = testDataImpl.createBankDummyData();
            if(created) {
                return "Dummy data is created successfully";
            } else {
                return "Dummy data is already available in db";
            }
        } catch(Exception e) {
            return "Unable to create dummy data";
        }
    }

}
