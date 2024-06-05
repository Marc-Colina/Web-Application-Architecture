package com.example.waa_lab_5.security.service.impl;

import com.example.waa_lab_5.security.dto.LoginRequest;
import com.example.waa_lab_5.security.dto.LoginResponse;
import com.example.waa_lab_5.security.dto.RefreshTokenRequest;
import com.example.waa_lab_5.security.service.spec.IAuthService;
import com.example.waa_lab_5.security.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public LoginResponse authenticate(LoginRequest loginRequest) {
        Authentication result = null;

        try {
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }

        LoginResponse loginResponse = new LoginResponse();
        String email = loginRequest.getEmail();
        loginResponse.setAccessToken(jwtUtil.generateToken(email));
        loginResponse.setRefreshToken(jwtUtil.generateRefreshToken(email));
        return loginResponse;
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken =
                    jwtUtil.generateToken(jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
            return new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
        }
        return new LoginResponse();
    }
}
