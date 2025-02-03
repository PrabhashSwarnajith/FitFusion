package lk.fitfusion.fitfusion_api.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import lk.fitfusion.fitfusion_api.dto.request.UserRequestDTO;
import lk.fitfusion.fitfusion_api.dto.response.LoginResponseDTO;
import lk.fitfusion.fitfusion_api.dto.response.ProfileResponseDTO;
import lk.fitfusion.fitfusion_api.dto.response.UserResponseDTO;
import lk.fitfusion.fitfusion_api.exception.UserNotFoundException;
import lk.fitfusion.fitfusion_api.model.User;
import lk.fitfusion.fitfusion_api.repository.UserRepository;
import lk.fitfusion.fitfusion_api.security.JwtService;
import lk.fitfusion.fitfusion_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;


    @Override
    public List<UserResponseDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public User updateUser(UserRequestDTO userRequestDTO,String jwt) {

        String username = jwtService.extractUsername(jwt);

        // Check if user is authenticated
        if (username == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }

        // Find user by username
        Optional<User> optionalUser = userRepository.findByUsername(username);

        // Check if user exists
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        // Update user information
        User user = optionalUser.get();
        user.setUsername(userRequestDTO.getUsername());
        user.setFirstname(userRequestDTO.getFirstname());
        user.setLastname(userRequestDTO.getLastname());
        user.setEmail(userRequestDTO.getEmail());

        // Save updated user
        try {
            userRepository.save(user);
        } catch (Exception ex) {

            // Return an appropriate response to the client
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while updating user", ex);
        }

        // Return updated user
        return user;
    }


    @Override
    public User findUserByJwt(String jwt) {
        String username = jwtService.extractUsername(jwt);
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.orElse(null);
    }


    @Override
    public List<User> searchUsers() {
        return List.of();
    }

    @Override
    public User followUser(String jwt, String userId) {
        User user = findUserByJwt(jwt);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

//        User reqeustedUser = userRepository.findById(user.getId());
//        User followedUser = userRepository.findById(userId).get();
//        if (user.getFollowings().contains(reqeustedUser.getFollowers())) {
//            userRepository.save(reqeustedUser);
//            userRepository.existsById(userId);
//        }
//        return followedUser;
        return userRepository.findById(userId).orElse(null);
    }
}
