package com.rollerspeed.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rollerspeed.dtos.UserDTO;
import com.rollerspeed.mappers.UserMapper;
import com.rollerspeed.models.User;
import com.rollerspeed.models.enums.UserStatus;
import com.rollerspeed.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        return userRepository.findByStatusNot(UserStatus.DELETED)
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id)
                .filter(user -> !user.getStatus().equals(UserStatus.DELETED))
                .map(userMapper::toDTO);
    }

    public UserDTO saveUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setStatus(UserStatus.ACTIVE);
        return userMapper.toDTO(userRepository.save(user));
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        if (userDTO.getUsername() != null && !userDTO.getUsername().isBlank()) {
            user.setUsername(userDTO.getUsername());
        }
        if (userDTO.getFullName() != null && !userDTO.getFullName().isBlank()) {
            user.setFullName(userDTO.getFullName());
        }
        if (userDTO.getEmail() != null && !userDTO.getEmail().isBlank()) {
            user.setEmail(userDTO.getEmail());
        }
        if (userDTO.getRole() != null) {
            user.setRole(userDTO.getRole());
        }
        if (userDTO.getStatus() != null) {
            user.setStatus(userDTO.getStatus());
        }
        if (userDTO.getPassword() != null && !userDTO.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }

        User updated = userRepository.save(user);
        return userMapper.toDTO(updated);
    }

    public User findByUsername(String userName) {
        return userRepository.findByUsername(userName).get();
    }

    public void deleteUser(Long id) {
        userRepository.findById(id).ifPresent(user -> {
            user.setStatus(UserStatus.DELETED);
            userRepository.save(user);
        });
    }
}
