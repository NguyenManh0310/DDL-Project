package com.example.authservice.Service.ServiceImpl;

import com.example.authservice.Dto.CustomException;
import com.example.authservice.Dto.LoginRequest;
import com.example.authservice.Dto.LoginResponse;
import com.example.authservice.Entity.User;
import com.example.authservice.Repository.UsersRepository;
import com.example.authservice.Service.AuthService;

import com.example.authservice.Util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UsersRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthServiceImpl(UsersRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
//        User user = userRepository.findByUserName(request.getUsername())
//                .orElseThrow(() -> new CustomException("Invalid username or password"));
//
//        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//            throw new CustomException("Invalid username or password");
//        }
//
//        if (user.getStatus()==0L) {
//            throw new CustomException("User account is inactive");
//        }asqw
//
//        String token = jwtUtil.generateToken(user.getUserName(), userRepository.);
//        return new LoginResponse(user.getUsername(), token, user.getRole());
        return null;
    }
}
