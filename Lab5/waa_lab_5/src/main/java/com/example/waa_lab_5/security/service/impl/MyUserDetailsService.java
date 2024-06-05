package com.example.waa_lab_5.security.service.impl;

import com.example.waa_lab_5.entity.User;
import com.example.waa_lab_5.repo.IUserRepo;
import com.example.waa_lab_5.security.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    private final IUserRepo userRepo;

    public MyUserDetailsService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        return new MyUserDetails(user);
    }
}
