package com.bank.token.services.counter;

import com.bank.constants.EntityType;
import com.bank.entity.CustomerToken;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by bhuvneshwars on 16/5/18.
 */
public class DepositServiceCounter implements IBankServiceCounter {

    Map<String, Queue<CustomerToken>> tokenTaskList= new HashMap<String, Queue<CustomerToken>>();
    static DepositServiceCounter accountServiceCounter = null;

    private DepositServiceCounter() { }

    public static DepositServiceCounter getInstance() {

        if(accountServiceCounter==null)
            accountServiceCounter = new DepositServiceCounter();

        return accountServiceCounter;
    }

    @Override
    public void addTokenToQueue(CustomerToken token) {

        String counterType = token.getCustomer().getServiceType();
        Queue queue = tokenTaskList.get(counterType);
        if(queue == null) {
            queue = new PriorityQueue<CustomerToken>();
        }
        queue.add(token);
        tokenTaskList.put(counterType, queue);
    }

    @Override
    public CustomerToken processToken(String counterType) {

        Queue<CustomerToken> queue = tokenTaskList.get(counterType);
        if(queue == null)
            return null;

        CustomerToken token = queue.poll();
        token.setStatus("COMPLETED");

        return token;
    }

    @Override
    public int pendingTokens() {

        return getTokenCount(EntityType.PREMIUM.toString()) + getTokenCount(EntityType.REGULAR.toString());
    }

    public int getTokenCount(String counterType) {

        int noOfTokens = 0;
        Queue queue = tokenTaskList.get(counterType);
        if(queue != null)
            noOfTokens = queue.size();
        return noOfTokens;
    }
}
