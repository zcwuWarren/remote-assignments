package com.example.demo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping
    // use @ResponseBody to tell Spring that return actual content instead of the name of view
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/data")
    @ResponseBody
    public String getTestNum(@RequestParam(value = "number", required = false) String number) {
        // check if the query parameter exist
        if (number == null) {
            return "Lack of Parameter";
        }
        try {
            long num = Long.parseLong(number);
            long sum = (num * (num + 1)) / 2;
            return Long.toString(sum);
        } catch (NumberFormatException e) {
            return "Wrong Parameter";
        }
    }

    @GetMapping("/myName")
    public String checkName(@CookieValue(value ="userNameCookie", required=false) String username, Model model) {
        if (username == null || username.isEmpty()) {
            return "home";
        } else {
            model.addAttribute("userName", username);
            return "storedCookie";
        }
    }

    // submit userName by form action attribute then use @RequestParam to get userName and set cookie
    // /trackName invoke by form that remain the same url
    @GetMapping("/trackName")
    public String getTrackName(@RequestParam String userName, HttpServletResponse response) {
        Cookie cookie = new Cookie("userNameCookie", userName);
        response.addCookie(cookie);
        return "redirect:/myName";
    }

    @GetMapping("/clear")
    public String deleteStoredCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("userNameCookie", null);
        response.addCookie(cookie);
        cookie.setMaxAge(0);
        return "redirect:/myName";
    }
}
