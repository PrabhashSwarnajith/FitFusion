package lk.fitfusion.fitfusion_api.service;

import lk.fitfusion.fitfusion_api.dto.request.LoginRequestDTO;
import lk.fitfusion.fitfusion_api.dto.request.RefreshTokenRequestDTO;
import lk.fitfusion.fitfusion_api.dto.request.RegisterRequestDTO;
import lk.fitfusion.fitfusion_api.dto.response.LoginResponseDTO;
import lk.fitfusion.fitfusion_api.dto.response.RefreshTokenResponseDTO;
import lk.fitfusion.fitfusion_api.dto.response.RegisterResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


public interface AuthService {

    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);

    RegisterResponseDTO registerUser(RegisterRequestDTO registerRequestDTO);

    RefreshTokenResponseDTO refreshAccessToken(RefreshTokenRequestDTO refreshTokenRequest);
}
