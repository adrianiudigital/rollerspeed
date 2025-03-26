package com.rollerspeed.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.rollerspeed.config.ApiRoutes;
import com.rollerspeed.config.RolesDefined;

@Configuration
public class SecurityConfig {

    private final ApiRoutes apiRoutes;
    private final RolesDefined rolesDefined;

    public SecurityConfig(ApiRoutes apiRoutes, RolesDefined rolesDefined) {
        this.apiRoutes = apiRoutes;
        this.rolesDefined = rolesDefined;
    }

    // Seguridad para API REST (JWT)
    @Bean
    public SecurityFilterChain apiSecurity(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter)
            throws Exception {
        http
                .securityMatcher("/api/**")
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        .anyRequest().authenticated())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public SecurityFilterChain webSecurity(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/**")
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                apiRoutes.PUBLIC_HOME,
                                apiRoutes.PUBLIC_MISION,
                                apiRoutes.PUBLIC_VISION,
                                apiRoutes.PUBLIC_VALORES,
                                apiRoutes.PUBLIC_SERVICIOS,
                                apiRoutes.PUBLIC_EVENTOS,
                                "/redirector",
                                apiRoutes.PUBLIC_LOGIN)
                        .permitAll()
                        .requestMatchers("/dashboard/admin/**").hasRole(rolesDefined.ROLE_ADMIN)
                        .requestMatchers("/dashboard/instructor/**").hasRole(rolesDefined.INSTRUCTOR)
                        .requestMatchers("/dashboard/student/**").hasRole(rolesDefined.STUDENT)
                        .anyRequest().authenticated())
                        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))

                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
