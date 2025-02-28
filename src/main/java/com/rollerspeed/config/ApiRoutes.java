package com.rollerspeed.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiRoutes {

    @Value("${api.auth.login}")
    public String LOGIN;

    @Value("${api.auth.register}")
    public String REGISTER;

    @Value("${api.auth.logout}")
    public String LOGOUT;

    @Value("${api.auth.me}")
    public String ME;

    @Value("${api.users.base}")
    public String USERS;

    @Value("${api.users.instructors}")
    public String INSTRUCTORS;

    @Value("${api.users.students}")
    public String STUDENTS;
}
