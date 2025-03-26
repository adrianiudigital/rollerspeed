package com.rollerspeed.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rollerspeed.models.User;
import com.rollerspeed.models.enums.UserStatus;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    
    List<User> findByStatusNot(UserStatus status);
}
