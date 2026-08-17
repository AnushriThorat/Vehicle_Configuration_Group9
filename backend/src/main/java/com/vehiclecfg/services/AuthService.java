package com.vehiclecfg.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vehiclecfg.dto.LoginRequest;
import com.vehiclecfg.dto.LoginResponse;
import com.vehiclecfg.dto.RegisterRequest;
import com.vehiclecfg.entities.User;
import com.vehiclecfg.jwt.jwtService;
import com.vehiclecfg.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final jwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       jwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    // Register User
    public String register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByCompanyEmail(request.getCompanyEmail())) {
            throw new RuntimeException("Company Email already exists");
        }

        User user = new User();

        user.setUsername(request.getUsername());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setCompanyName(request.getCompanyName());
        user.setCompanyEmail(request.getCompanyEmail());
        user.setRegistrationNo(request.getRegistrationNo());
        user.setHoldingType(request.getHoldingType());

        user.setAddress1(request.getAddress1());
        user.setAddress2(request.getAddress2());

        user.setCity(request.getCity());
        user.setState(request.getState());
        user.setPin(request.getPin());

        user.setAuthorizedPersonName(request.getAuthorizedPersonName());
        user.setDesignation(request.getDesignation());
        user.setAuthPersonTel(request.getAuthPersonTel());

        user.setCell(request.getCell());
        user.setPhone(request.getPhone());
        user.setFax(request.getFax());

        user.setCompanyStNo(request.getCompanyStNo());
        user.setCompanyVatNo(request.getCompanyVatNo());
        user.setTaxPan(request.getTaxPan());

        userRepository.save(user);

        return "Registration Successful";
    }

    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(

                        request.getUsername(),

                        request.getPassword()

                )

        );

        User user = userRepository.findByUsername(request.getUsername());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        String token = jwtService.generateToken(user.getUsername());

        return new LoginResponse(

                user.getId(),

                user.getUsername(),

                token

        );

    }

}