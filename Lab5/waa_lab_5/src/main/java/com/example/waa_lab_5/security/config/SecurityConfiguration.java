package com.example.waa_lab_5.security.config;

import com.example.waa_lab_5.entity.Role;
//import com.example.waa_lab_4.security.JwtFilter;
import com.example.waa_lab_5.security.JwtFilter;
import com.example.waa_lab_5.service.spec.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true,
        jsr250Enabled = true,
        securedEnabled = true
)

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    private final IRoleService iRoleService;
    private final JwtFilter jwtFilter;
    private final UserDetailsService userDetailsService;

    public SecurityConfiguration(IRoleService iRoleService, JwtFilter jwtFilter, UserDetailsService userDetailsService) {
        this.iRoleService = iRoleService;
        this.jwtFilter = jwtFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public UserDetailsService userDetailService() {
        return userDetailsService;
    }
//
//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http,
//                                             BCryptPasswordEncoder bCryptPasswordEncoder,
//                                             UserDetailsService userDetailService)
//            throws Exception {
//
//        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        builder.userDetailsService(userDetailService)
//                .passwordEncoder(bCryptPasswordEncoder);
//        return builder.build();
//    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/authenticate")
                        .permitAll()
                        .requestMatchers("/admin").hasAuthority("ROLE_ADMIN")
                        .anyRequest().hasAnyAuthority(getRoles()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    private String getRoles() {
        return iRoleService.findAll().stream()
                .map(Role::getRole)
                .reduce("", (role1, role2) -> role1 + "," + role2);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());

        return authProvider;
    }


}