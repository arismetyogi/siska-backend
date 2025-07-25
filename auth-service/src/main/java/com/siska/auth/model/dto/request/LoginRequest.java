package com.siska.auth.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotNull(message = "username can not be empty!")
    private String username;
    @NotNull(message = "password can not be empty!")
    private String password;
}
