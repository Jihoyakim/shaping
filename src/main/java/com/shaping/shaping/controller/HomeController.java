package com.shaping.shaping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/",""})
    public String home(HttpSession session, Model model){

        String username = (String) session.getAttribute("username");
        if (username != null) {
            model.addAttribute("username", username);
        } else {
            model.addAttribute("username", "Guest");
        }
        return "main";
    }

}
