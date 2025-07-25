package com.siska.auth.service;

import com.siska.auth.model.dto.request.LoginRequest;
import com.siska.auth.model.dto.response.AuthResponse;
import com.siska.auth.model.dto.response.ProfileResponse;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    ProfileResponse validateToken(String token);
}
