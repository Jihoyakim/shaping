package com.shaping.shaping.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

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
    @GetMapping("/checkRole")
    public ResponseEntity<String> checkRole(Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("authentication == null");
        } else if (authentication instanceof AnonymousAuthenticationToken) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("authentication == ???");
        }

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        boolean hasRole = authorities.stream()
                .anyMatch(authority -> authority.getAuthority().equals("USER"));

        if (hasRole) {
            return ResponseEntity.ok("User has USER");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User does not have USER");
        }
    }

    @GetMapping("/session-info")
    public ResponseEntity<String> getSessionInfo(HttpSession session) {
        String username = (String) session.getAttribute("username");
        String roles = (String) session.getAttribute("userRole");
        Object securityContext = session.getAttribute("SPRING_SECURITY_CONTEXT");
        return ResponseEntity.ok("Username: " + username + ", Roles: " + roles + ", Security Context: " + securityContext);
    }

    @GetMapping(value = "/admin/dashboard")
//    @PreAuthorize("hasRole('ADMIN')")
    public String manage(){
        return "/admin/dashboard";
    }

}
