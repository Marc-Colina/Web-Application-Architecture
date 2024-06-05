package com.example.waa_lab_5.security.service.spec;

import com.example.waa_lab_5.security.dto.LoginRequest;
import com.example.waa_lab_5.security.dto.LoginResponse;
import com.example.waa_lab_5.security.dto.RefreshTokenRequest;

public interface IAuthService {
    LoginResponse authenticate(LoginRequest loginRequest);

    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
