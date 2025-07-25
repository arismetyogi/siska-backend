package com.siska.auth.controller;

import com.siska.auth.model.dto.request.LoginRequest;
import com.siska.auth.model.dto.response.AuthResponse;
import com.siska.auth.model.dto.response.ProfileResponse;
import com.siska.auth.model.entity.UserEntity;
import com.siska.auth.repository.UserRepository;
import com.siska.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {
    private final AuthService userService;
    private final UserRepository userRepository;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        System.out.println("Login username: " + request.getUsername());
        System.out.println("User in repo? " + userRepository.findByUsername(request.getUsername()).isPresent());
        return ResponseEntity.ok(userService.login(request));
    }

    @PostMapping("/validate")
    public ResponseEntity<ProfileResponse> validateToken(@RequestHeader("Authorization") String token) {
        String jwtToken = token.substring(7); // Remove "Bearer " prefix
        ProfileResponse user = authService.validateToken(jwtToken);
        return ResponseEntity.ok(user);
    }
}
