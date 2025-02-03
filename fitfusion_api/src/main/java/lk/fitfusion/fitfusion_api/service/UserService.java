package lk.fitfusion.fitfusion_api.service;

import lk.fitfusion.fitfusion_api.dto.request.UserRequestDTO;
import lk.fitfusion.fitfusion_api.dto.response.UserResponseDTO;
import lk.fitfusion.fitfusion_api.model.User;


import java.util.List;

public interface UserService {
    List<UserResponseDTO> getAllUsers();
    User updateUser(UserRequestDTO userRequestDTO,String jwt);
    User findUserByJwt(String jwt);
    List<User> searchUsers();
    User followUser(String jwt,String userId);
}
