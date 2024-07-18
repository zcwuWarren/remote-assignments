package com.example.demo.controller;


import com.example.demo.dto.UserRequest;
import com.example.demo.model.User;
import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
public class UserController {

    @Autowired
    private Service service;

    @GetMapping("/")
    // use two @ModelAttribute to render page depend on different case
    public String homePage(@ModelAttribute("error") String error, @ModelAttribute("signup_error") String signup_error, Model model) {
        if (error != null) {
            model.addAttribute("error");
        }

        if (signup_error != null) {
            model.addAttribute("signup_error");
        }
        return "homePage";
    }

    @PostMapping("/memberpage")
    // @RequestBody only handling JSON, but form-data default enctype is url-encode,so if ass @RequestBody will get error
    // use RedirectAttributes to pass attribute to redirect url
    // use addFlashAttribute to make attribute removed after next request (while use addAttribute will show in query string)
    public String getUser(@ModelAttribute UserRequest userRequest, RedirectAttributes redirectAttributes) {
        String email = userRequest.getEmail();
        String password = userRequest.getPassword();

        User getUserInfo = service.getUser(email, password);
        if (getUserInfo != null) {
            return "greeting";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid email or password");
        }
        return "redirect:/";
    }

    @PostMapping("/create")
    public String register(@ModelAttribute UserRequest userRequest, RedirectAttributes redirectAttributes) {
        String email = userRequest.getEmail();
        String password = userRequest.getPassword();

        User checkUserInfo = service.checkUser(email);
        if (checkUserInfo != null) {
            redirectAttributes.addFlashAttribute("signup_error", "User already exists");
            return "redirect:/";
        }

        User newUserInfo = service.createUser(email, password);
        if (newUserInfo != null) {
            return "greeting";
        }
        return "redirect:/";
    }
}



