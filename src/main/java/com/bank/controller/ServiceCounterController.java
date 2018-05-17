package com.bank.controller;

import com.bank.entity.CustomerToken;
import com.bank.entity.ServiceCounter;
import com.bank.service.impl.ServiceCounterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by bhuvneshwars on 15/5/18.
 */
@RestController
public class ServiceCounterController {

    @Autowired
    ServiceCounterImpl serviceCounter;

    @RequestMapping(value = "/serviceCounter")
    List<ServiceCounter> getServiceCounterList() {

        List<ServiceCounter> serviceCounterList =  serviceCounter.getServiceCounterList();
        return serviceCounterList;
    }

    @RequestMapping(value = "/serviceCounter/{serviceType}/tokens")
    List<CustomerToken> getTokensForServiceCounter(@PathVariable String serviceType) {

        List<CustomerToken> tokens = serviceCounter.getTokensForServiceCounter(serviceType);
        return tokens;
    }
}
