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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public AuthServiceImpl(JwtUtil jwtUtil, AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
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

        final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());

        LoginResponse loginResponse = new LoginResponse();
        String email = loginRequest.getEmail();
        loginResponse.setAccessToken(jwtUtil.generateToken(userDetails));
        loginResponse.setRefreshToken(jwtUtil.generateRefreshToken(email));
        return loginResponse;
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            // TODO (check the expiration of the accessToken when request sent, if the is recent according to
            //  issue Date, then accept the renewal)
            var isAccessTokenExpired = jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());
            if (isAccessTokenExpired)
                System.out.println("ACCESS TOKEN IS EXPIRED"); // TODO Renew is this case
            else
                System.out.println("ACCESS TOKEN IS NOT EXPIRED");
            final String accessToken =
                    jwtUtil.doGenerateToken(jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            // TODO (OPTIONAL) When to renew the refresh token?
            return loginResponse;
        }
        return new LoginResponse();
    }
}
