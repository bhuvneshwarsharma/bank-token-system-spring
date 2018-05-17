package com.bank.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bhuvneshwars on 16/5/18.
 */
public enum  EntityType {

    PREMIUM,
    REGULAR;

    static final Map<String, EntityType> entityTypeMap = new HashMap() {
        {
            put("premium", PREMIUM);
            put("regular", REGULAR);
        }
    };

    public static String getEntityType(String entityType) {

        Object entityTypeObj = entityTypeMap.get(entityType.toLowerCase());
        return entityTypeObj.toString();
    }
}
