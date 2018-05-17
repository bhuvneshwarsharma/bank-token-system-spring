package com.bank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bhuvneshwars on 15/5/18.
 */
@RestController
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {

        return "Coming to home page";
    }
}
