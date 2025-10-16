package com.apibancosecurity.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
//        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder encoder) {

        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("adminpass"))
                .roles(UserRole.ADMIN)
                .build();
        UserDetails user = User.withUsername("user")
                .password(encoder.encode("userpass"))
                .roles(UserRole.USER)
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                authorizeHttpRequests(auth -> auth
                        .requestMatchers(("/api/admin/**")).hasRole(UserRole.ADMIN)
                        .requestMatchers(("/api/user/**")).hasAnyRole(UserRole.USER, UserRole.ADMIN)
                        .anyRequest().authenticated()

                ).csrf(csrf -> csrf.disable())
                .exceptionHandling(exception -> exception.accessDeniedHandler(customAccessDeniedHandler))
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
