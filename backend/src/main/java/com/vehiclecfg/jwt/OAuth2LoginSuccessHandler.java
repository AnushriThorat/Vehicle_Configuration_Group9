package com.vehiclecfg.jwt;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.vehiclecfg.entities.User;
import com.vehiclecfg.repository.UserRepository;

@Component
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private jwtService jwtService;

    // Local encoder to avoid circular dependency
    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication)
            throws IOException, ServletException {

        OAuth2User oauthUser =
                (OAuth2User) authentication.getPrincipal();

        String email =
                oauthUser.getAttribute("email");

        String name =
                oauthUser.getAttribute("name");

        Optional<User> optionalUser =
                userRepository.findByCompanyEmail(email);

        User user;

        if (optionalUser.isPresent()) {

            user = optionalUser.get();

        } else {

            user = new User();

            user.setUsername(email);

            user.setCompanyEmail(email);

            user.setCompanyName(name);

            user.setPassword(
                    passwordEncoder.encode(
                            UUID.randomUUID().toString()
                    )
            );

            user = userRepository.save(user);

        }

        String token =
                jwtService.generateToken(user.getUsername());

        response.sendRedirect(
                "http://localhost:5173/oauth-success"
                + "?token=" + token
                + "&userId=" + user.getId()
                + "&username=" + user.getUsername()
        );
    }
}