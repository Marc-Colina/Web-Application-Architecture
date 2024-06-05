package com.example.waa_lab_5.security;

import com.example.waa_lab_5.entity.Role;
import com.example.waa_lab_5.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {
    private String email;

    @JsonIgnore
    private String password;

    private List<Role> roles;

    public MyUserDetails(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> result = roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole().toUpperCase(Locale.ROOT)))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
