package lk.fitfusion.fitfusion_api.service.impl;

import io.jsonwebtoken.ExpiredJwtException;
import lk.fitfusion.fitfusion_api.dto.request.LoginRequestDTO;
import lk.fitfusion.fitfusion_api.dto.request.RefreshTokenRequestDTO;
import lk.fitfusion.fitfusion_api.dto.request.RegisterRequestDTO;
import lk.fitfusion.fitfusion_api.dto.response.LoginResponseDTO;
import lk.fitfusion.fitfusion_api.dto.response.RefreshTokenResponseDTO;
import lk.fitfusion.fitfusion_api.dto.response.RegisterResponseDTO;
import lk.fitfusion.fitfusion_api.model.Role;
import lk.fitfusion.fitfusion_api.model.User;
import lk.fitfusion.fitfusion_api.repository.UserRepository;
import lk.fitfusion.fitfusion_api.security.JwtService;
import lk.fitfusion.fitfusion_api.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    public LoginResponseDTO login(LoginRequestDTO requestDTO) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            requestDTO.getUsername(),
                            requestDTO.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            throw new RuntimeException("Authentication failed: " + e.getMessage(), e);
        }

        User user = userRepository.findByUsername(requestDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token;
        String refreshToken;
        try {
            token = jwtService.generateToken(user);
            refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);
        } catch (ExpiredJwtException ex) {
            // Handle token expiration
            throw new RuntimeException("Token expired: " + ex.getMessage(), ex);
        }

        return new LoginResponseDTO(token,refreshToken, "User Login Successful");
    }

    @Override
    public RegisterResponseDTO registerUser(RegisterRequestDTO registerRequestDTO) {

        if (userRepository.existsByUsername(registerRequestDTO.getUsername())) {
            return new RegisterResponseDTO(null, "Username already exists");
        }

        if (userRepository.existsByEmail(registerRequestDTO.getEmail())) {
            return new RegisterResponseDTO(null, "Email already exists");
        }

        User user = User.builder()
                .username(registerRequestDTO.getUsername())
                .firstname(registerRequestDTO.getFirstname())
                .lastname(registerRequestDTO.getLastname())
                .email(registerRequestDTO.getEmail())
                .gender(registerRequestDTO.getGender())
                .password(passwordEncoder.encode(registerRequestDTO.getPassword()))
                .role(Role.USER)
                .build();

        String token = jwtService.generateToken(user);
        userRepository.save(user);
        return  new RegisterResponseDTO(token, "User Register Successful");
    }

    @Override
    public RefreshTokenResponseDTO refreshAccessToken(RefreshTokenRequestDTO refreshTokenRequest) {

        String refreshToken = refreshTokenRequest.getRefreshToken();

        try {
            // Extract username from refresh token
            String username = jwtService.extractUsername(refreshToken);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // Generate new access token
            String accessToken = jwtService.generateToken(userDetails);

            // Return new access token to the client
            return new RefreshTokenResponseDTO(accessToken);
        } catch (Exception e) {
            // Handle token validation or generation errors
            throw new RuntimeException("Failed to refresh access token", e);
        }
    }
}
