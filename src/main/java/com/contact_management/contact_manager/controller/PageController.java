package com.contact_management.contact_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.contact_management.contact_manager.Forms.SignUpForm;
import com.contact_management.contact_manager.entity.Users;
import com.contact_management.contact_manager.services.UserServices;

import jakarta.validation.Valid;

@RestController
public class PageController {
    // @GetMapping("/base")
    // public ModelAndView base()
    // {
    // return new ModelAndView("base");
    // }
    @Autowired
    private UserServices userservices;

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @GetMapping("/services")
    public ModelAndView services() {
        return new ModelAndView("services");
    }

    @GetMapping("/about")
    public ModelAndView about() {
        return new ModelAndView("about");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/signup")
    public ModelAndView signup(Model model) {
        model.addAttribute("signupform", new SignUpForm());
        return new ModelAndView("signup");
    }

    @PostMapping("/register")
    public ModelAndView Register(@Valid @ModelAttribute SignUpForm form,BindingResult bindingResult) {

        System.out.println(form);

        if(bindingResult.hasErrors())
        return new ModelAndView("signup");

        // save user
        Users users = new Users();

        users.setName(form.getName());
        users.setEmail(form.getEmail());
        users.setPassword(form.getPassword());
        users.setPhoneNo(form.getPhoneNo());
        users.setAbout(form.getAbout());

        @SuppressWarnings("unused")
        Users saveduser = userservices.saveUsers(users);

        System.out.println("User Saved");

        return new ModelAndView("login");
    }

}
