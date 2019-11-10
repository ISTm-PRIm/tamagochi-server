package com.tamogochi.server.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @GetMapping("/config/")
    @PreAuthorize("hasRole('USER')")
    public String getConfigValue() {
        return System.getenv("FACEBOOK_CLIENT_SECRET");
    }
}
