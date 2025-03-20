package com.rollerspeed.dtos;

import com.rollerspeed.models.enums.UserRole;
import com.rollerspeed.models.enums.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String fullName;
    private String email;
    private UserRole role;
    private String password;
    private UserStatus status;
}
