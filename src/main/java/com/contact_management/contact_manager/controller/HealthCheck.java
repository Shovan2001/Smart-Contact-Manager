package com.contact_management.contact_manager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck 
{
    @GetMapping("/heathCheck")
    public String healthCheck() {
        return "OKK";
    }

    @GetMapping("/heathCheck2")
    public String healthCheck2() {
        return "all good";
    }
    

}
