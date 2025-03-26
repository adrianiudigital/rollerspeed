package com.rollerspeed.mappers;

import java.util.List;
import java.util.stream.Collectors;

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
                .status(user.getStatus())
                .build();
    }

    public User toEntity(UserDTO userDTO) {
        return User.builder()
                .username(userDTO.getUsername())
                .fullName(userDTO.getFullName())
                .email(userDTO.getEmail())
                .role(userDTO.getRole())
                .status(userDTO.getStatus())
                .build();
    }

    public List<UserDTO> toDTOList(List<User> users) {
        return users.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<User> toEntityList(List<UserDTO> userDTOs) {
        return userDTOs.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
