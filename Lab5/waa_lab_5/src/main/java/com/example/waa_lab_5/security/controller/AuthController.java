package com.example.waa_lab_5.security.controller;

import com.example.waa_lab_5.security.dto.LoginRequest;
import com.example.waa_lab_5.security.dto.LoginResponse;
import com.example.waa_lab_5.security.service.spec.IAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthController {
    IAuthService iAuthService;

    public AuthController(IAuthService iAuthService) {
        this.iAuthService = iAuthService;
    }

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = iAuthService.authenticate(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }
}
