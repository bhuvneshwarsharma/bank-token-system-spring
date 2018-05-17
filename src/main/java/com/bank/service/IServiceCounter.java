package com.bank.service;

import com.bank.entity.CustomerToken;
import com.bank.entity.ServiceCounter;

import java.util.List;

/**
 * Created by bhuvneshwars on 16/5/18.
 */
public interface IServiceCounter {

    List<ServiceCounter> getServiceCounterList();
    List<CustomerToken> getTokensForServiceCounter(String serviceType);
}
