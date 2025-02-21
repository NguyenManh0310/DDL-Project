package com.example.authservice.Service;

import com.example.authservice.Dto.LoginRequest;
import com.example.authservice.Dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
