package com.bank.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bhuvneshwars on 16/5/18.
 */
public enum ServiceType {

    ACCOUNT,
    DEPOSIT,
    WITHDRAW,
    ENQUIERY;

    static final Map<String, ServiceType> serviceTypeMap = new HashMap() {
        {
            put("account", ACCOUNT);
            put("deposit", DEPOSIT);
            put("withdraw", WITHDRAW);
            put("enquiery", ENQUIERY);
        }
    };

    public static String getServiceType(String serviceType) {

        Object entityTypeObj = serviceTypeMap.get(serviceType.toLowerCase());
        return entityTypeObj.toString();
    }

    public static ServiceType getService(String serviceType) {

        return serviceTypeMap.get(serviceType.toLowerCase());
    }
}
