package com.bank.controller;

import com.bank.service.impl.TokenServiceImpl;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.rabbitmq.tools.json.JSONReader;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bhuvneshwars on 15/5/18.
 */
@RestController
public class TokenController {

    private static final Logger logger = LoggerFactory.getLogger(TokenController.class);

    @Autowired
    TokenServiceImpl tokenService;

    @PostMapping(value = "/token")
    public String generateToken(@RequestBody String json) {

        try {
            JSONObject jsonObj=new JSONObject(json);
            String phoneNumber = jsonObj.getString("phoneNumber");
            String serviceType = jsonObj.getString("serviceType");

            String message = tokenService.generateToken(phoneNumber, serviceType);
            return message;

        } catch(Exception e) {

            logger.error("Facing issue while creating new token : "+e.getMessage());
            return "Facing issue while creating new token";
        }
    }

    @PutMapping(value = "/token")
    public String processToken(@RequestBody String json) {

        try {
            JSONObject jsonObj=new JSONObject(json);
            String counterName = jsonObj.getString("counterName");
            String message = tokenService.processToken(counterName);

            return message;

        } catch(Exception e) {

            logger.error("Facing issue while processing token : "+e.getMessage());
            return "Facing issue while processing token";
        }
    }
}
