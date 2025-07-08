package com.secuirty.jwt.service;

import com.secuirty.jwt.entity.Users;
import com.secuirty.jwt.repository.UserDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AdminUserIntializer {

    public CommandLineRunner adminUserInitializer(UserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if(userDetailsRepository.findByUsername("admin").isEmpty()) {
                Users adminUser = new Users();
                adminUser.setUsername("admin");
                adminUser.setPassword(passwordEncoder.encode("admin123"));
                adminUser.setRole("ROLE_ADMIN");
                userDetailsRepository.save(adminUser);
            }
            System.out.println("Admin user initialized successfully.");
        };
    }
}
