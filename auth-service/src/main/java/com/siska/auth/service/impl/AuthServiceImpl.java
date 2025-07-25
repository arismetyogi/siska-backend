package com.siska.auth.service.impl;

import com.siska.auth.exception.ResourceAlreadyExistedException;
import com.siska.auth.model.dto.request.LoginRequest;
import com.siska.auth.model.dto.response.AuthResponse;
import com.siska.auth.model.dto.response.ProfileResponse;
import com.siska.auth.model.entity.UserEntity;
import com.siska.auth.model.enums.RoleEnum;
import com.siska.auth.repository.UserRepository;
import com.siska.auth.service.AuthService;
import com.siska.auth.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (AuthenticationException ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage());
        }

        UserEntity userEntity = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token = jwtUtil.generateToken(userEntity);
        return new AuthResponse(token, userEntity.getUsername(), userEntity.getRole().name());
    }

    @Override
    public ProfileResponse validateToken(String token) {
        String username = jwtUtil.extractUsername(token);
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return ProfileResponse.builder()
                    .token(token)
                    .userId(user.get().getUserId())
                    .name(user.get().getName())
                    .username(user.get().getUsername())
                    .email(user.get().getEmail())
                    .isActive(user.get().getIsActive().toString())
                    .role(user.get().getRole().name())
                    .build();
        }
        throw new UsernameNotFoundException("User not found");
    }
}
