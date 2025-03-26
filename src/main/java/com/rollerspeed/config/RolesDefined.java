package com.rollerspeed.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RolesDefined {

    // --- ROLES ---
    @Value("${constants.strings.values.users.roles.admin}")
    public String ROLE_ADMIN;

    @Value("${constants.strings.values.users.roles.instructor}")
    public String INSTRUCTOR;

    @Value("${constants.strings.values.users.roles.student}")
    public String STUDENT;

}
