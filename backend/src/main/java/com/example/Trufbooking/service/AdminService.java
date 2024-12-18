package com.example.Trufbooking.service;

import com.example.Trufbooking.entity.Admin;
import com.example.Trufbooking.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Register Admin
    public Admin registerAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));  // Encrypt password before saving
        return adminRepository.save(admin);
    }

//    public Admin registerAdmin(Admin admin) {
//        admin.setPassword(passwordEncoder.encode(admin.getPassword()));  // Encrypt password before saving
//        return adminRepository.save(admin);

    // Authenticate Admin
    public boolean authenticate(String username, String password) {
        return adminRepository.findByUsername(username)
                .map(admin -> passwordEncoder.matches(password, admin.getPassword()))
                .orElse(false);
    }
}
