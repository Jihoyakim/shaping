package com.shaping.shaping.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {
    @GetMapping(value = "/dashboard")
//    @PreAuthorize("hasRole('ADMIN')")
    public String dashboard(){
        return "/admin/dashboard";
    }

    @GetMapping(value = "/users")
    public String manage(){
        return "/admin/manage";
    }
}
