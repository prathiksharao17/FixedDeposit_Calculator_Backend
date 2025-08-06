package com.customer.module.service;

import com.customer.module.dto.AuthResponse;
import com.customer.module.dto.LoginRequest;
import com.customer.module.dto.RegisterRequest;
import com.customer.module.entity.CustomerDetails;
import com.customer.module.entity.CustomerProofOfIdentity;
import com.customer.module.entity.User;
import com.customer.module.repository.CustomerDetailsRepository;
import com.customer.module.repository.CustomerProofOfIdentityRepository;
import com.customer.module.repository.UserRepository;
import com.customer.module.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CustomerDetailsRepository customerRepo;

    @Autowired
    private CustomerProofOfIdentityRepository proofRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthResponse register(RegisterRequest request) {
        // Save CustomerDetails
        CustomerDetails savedCustomer = customerRepo.save(request.getCustomer());

        // Save Proof
        CustomerProofOfIdentity proof = request.getProof();
        proof.setCustomer(savedCustomer);
        proofRepo.save(proof);

        // Save User
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setCustomer(savedCustomer);
        userRepo.save(user);

        // Generate Token
        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setRole(user.getRole());
        return response;
    }
    
    

    public AuthResponse login(LoginRequest request) {
        User user = userRepo.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setRole(user.getRole());
        return response;
    }
}
