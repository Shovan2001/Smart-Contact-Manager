package com.contact_management.contact_manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController 
{
    @GetExchange("/dashboard")
    public ModelAndView userDashboard()
    {
        return new ModelAndView("users/dashboard");
    }

    @GetExchange("/profile")
    public ModelAndView userProfile()
    {
        return new ModelAndView("users/profile");
    }

}
