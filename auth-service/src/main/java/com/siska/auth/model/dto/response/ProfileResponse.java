package com.siska.auth.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileResponse {
    private String token;
    private String userId;
    private String name;
    private String username;
    private String email;
    private String isActive;
    private String role;
}
