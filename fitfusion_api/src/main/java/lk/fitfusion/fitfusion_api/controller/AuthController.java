package lk.fitfusion.fitfusion_api.controller;

import lk.fitfusion.fitfusion_api.dto.request.LoginRequestDTO;
import lk.fitfusion.fitfusion_api.dto.request.RefreshTokenRequestDTO;
import lk.fitfusion.fitfusion_api.dto.request.RegisterRequestDTO;
import lk.fitfusion.fitfusion_api.dto.response.LoginResponseDTO;
import lk.fitfusion.fitfusion_api.dto.response.RefreshTokenResponseDTO;
import lk.fitfusion.fitfusion_api.dto.response.RegisterResponseDTO;
import lk.fitfusion.fitfusion_api.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth/")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO authenticate(@RequestBody LoginRequestDTO loginRequestDTO){
        return authService.login(loginRequestDTO);
    }

    @PostMapping("/register")
    public RegisterResponseDTO register(@RequestBody RegisterRequestDTO registerRequestDTO){
        return authService.registerUser(registerRequestDTO);
    }

    @PostMapping("/refresh")
    public RefreshTokenResponseDTO refreshAccessToken(@RequestBody RefreshTokenRequestDTO refreshTokenRequest) {
        return authService.refreshAccessToken(refreshTokenRequest);
    }


}
