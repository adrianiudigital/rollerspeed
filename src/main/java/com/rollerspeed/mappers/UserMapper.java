package com.rollerspeed.mappers;

import org.springframework.stereotype.Component;

import com.rollerspeed.dtos.UserDTO;
import com.rollerspeed.models.User;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .role(user.getRole())
                .deleted(user.getDeleted())
                .build();
    }

    public User toEntity(UserDTO userDTO) {
        return User.builder()
                .username(userDTO.getUsername())
                .fullName(userDTO.getFullName())
                .email(userDTO.getEmail())
                .role(userDTO.getRole())
                .deleted(userDTO.getDeleted())
                .build();
    }
}
