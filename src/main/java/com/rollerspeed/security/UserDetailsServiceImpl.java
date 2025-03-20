package com.rollerspeed.security;

import com.rollerspeed.models.User;
import com.rollerspeed.models.enums.UserRole;
import com.rollerspeed.models.enums.UserStatus;
import com.rollerspeed.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void ensureAdminExists() {
        Optional<User> admin = userRepository.findByUsername("admin");
        if (admin.isEmpty()) {
            User defaultAdmin = new User();
            defaultAdmin.setUsername("admin");
            defaultAdmin.setPassword(passwordEncoder.encode("1234"));
            defaultAdmin.setFullName("Administrador");
            defaultAdmin.setEmail("admin@example.com");
            defaultAdmin.setRole(UserRole.ADMIN);
            defaultAdmin.setStatus(UserStatus.ACTIVE);

            userRepository.save(defaultAdmin);
            System.out.println("✅ Usuario admin creado con éxito.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
    }
}
