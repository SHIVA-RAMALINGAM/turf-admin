package com.example.Trufbooking.service;

import com.example.Trufbooking.config.UserPrincipal;
import com.example.Trufbooking.entity.usertable;
import com.example.Trufbooking.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private userrepository userrepo;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public MyUserDetailService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        usertable user = userrepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }

    // Registration
    public usertable registerUser(usertable user) {
        // Encrypt password before saving
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userrepo.save(user);
    }

    // Authentication
    public boolean authenticate(String username, String password) {
        usertable user = userrepo.findByUsername(username);
        if (user == null || !bCryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new UsernameNotFoundException("Invalid credentials");
        }
        return true;
    }
}
