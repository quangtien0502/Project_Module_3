package com.example.ra.model.dto.Response;

import com.example.ra.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class JwtResponse {
    private String accessToken;
    private final String type = "Bearer";
    private String fullName;
    private String userName;
    private Boolean status;
    private Set<String> role;

}
