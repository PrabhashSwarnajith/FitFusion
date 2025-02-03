package lk.fitfusion.fitfusion_api.controller;

import lk.fitfusion.fitfusion_api.dto.request.UserRequestDTO;
import lk.fitfusion.fitfusion_api.model.User;
import lk.fitfusion.fitfusion_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;




@RestController
@AllArgsConstructor
@RequestMapping("/api/users/")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public User getUserFromToken(@RequestHeader ("Authorization")String jwt) {
        User user = userService.findUserByJwt(jwt);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }
        user.setPassword(null);
        return user;
    }

    @PutMapping("/profile")
    public ResponseEntity<User> updateUser(@RequestHeader ("Authorization")String jwt,@RequestBody UserRequestDTO userRequestDTO) {

        User updatedUser = userService.updateUser(userRequestDTO,jwt);

        // Check if the update was successful
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser); // Return updated user
        } else {
            // Handle case where user update failed
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // Follow another user
    @PostMapping("/follow/{userId}")
    public User followUser(@RequestHeader ("Authorization")String jwt, @PathVariable String userId) {
       return userService.followUser(jwt, userId);
    }

    // Unfollow a user
    @PostMapping("/{userId}/unfollow")
    public ResponseEntity<?> unfollowUser(@PathVariable String userId, @RequestParam("unfollowUserId") Integer unfollowUserId) {
        return null;
    }

}
