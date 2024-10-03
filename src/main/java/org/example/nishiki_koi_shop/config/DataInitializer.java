package org.example.nishiki_koi_shop.config;

import org.example.nishiki_koi_shop.model.entity.Role;
import org.example.nishiki_koi_shop.model.entity.User;
import org.example.nishiki_koi_shop.repository.RoleRepository;
import org.example.nishiki_koi_shop.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("Nguyen Lam").isEmpty()){
                Role userRole = roleRepository.findByName("ROLE_CUSTOMER")
                        .orElseGet(() -> roleRepository.save(Role.builder().name("ROLE_CUSTOMER").build()));

                User user = User.builder()
                        .username("Nguyen Lam")
                        .email("lam1782004@gmail.com")
                        .password(passwordEncoder.encode("123456"))
                        .fullName("Nguyen Thanh Lam")
                        .role(userRole)
                        .createdDate(LocalDate.now())
                        .address("42/1")
                        .phoneNumber("0362651806")
                        .build();

                userRepository.save(user);
            }

            if (userRepository.findByUsername("manager").isEmpty()) {
                Role managerRole = roleRepository.findByName("ROLE_MANAGER")
                        .orElseGet(() -> roleRepository.save(Role.builder().name("ROLE_MANAGER").build()));

                // Create admin user with ROLE_ADMIN
                User admin = User.builder()
                        .username("manager")
                        .email("manager@example.com")
                        .password(passwordEncoder.encode("123456"))
                        .fullName("Manager User")
                        .role(managerRole)
                        .createdDate(LocalDate.now())
                        .address("42/1")
                        .phoneNumber("0362651806")
                        .build();

                userRepository.save(admin);
            }
        };
    }
}
