package com.rollerspeed.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiRoutes {

    // --- Auth API ---
    @Value("${api.auth.login}")
    public String LOGIN;

    @Value("${api.auth.register}")
    public String REGISTER;

    @Value("${api.auth.logout}")
    public String LOGOUT;

    @Value("${api.auth.me}")
    public String ME;

    // --- Users API ---
    @Value("${api.users.base}")
    public String USERS;

    @Value("${api.users.instructors}")
    public String INSTRUCTORS;

    @Value("${api.users.students}")
    public String STUDENTS;

    // --- HTML públicos ---
    @Value("${routes.public.home}")
    public String PUBLIC_HOME;

    @Value("${routes.public.mision}")
    public String PUBLIC_MISION;

    @Value("${routes.public.vision}")
    public String PUBLIC_VISION;

    @Value("${routes.public.valores}")
    public String PUBLIC_VALORES;

    @Value("${routes.public.servicios}")
    public String PUBLIC_SERVICIOS;

    @Value("${routes.public.eventos}")
    public String PUBLIC_EVENTOS;

    @Value("${routes.public.login}")
    public String PUBLIC_LOGIN;

    @Value("${routes.public.register}")
    public String PUBLIC_REGISTER;

    // --- Dashboards por rol ---
    @Value("${routes.admin.dashboard}")
    public String ADMIN_DASHBOARD;

    @Value("${routes.instructor.dashboard}")
    public String INSTRUCTOR_DASHBOARD;

    @Value("${routes.student.dashboard}")
    public String STUDENT_DASHBOARD;

    @Value("${routes.logout.success.url}")
    private String logoutSuccessUrl;

}
