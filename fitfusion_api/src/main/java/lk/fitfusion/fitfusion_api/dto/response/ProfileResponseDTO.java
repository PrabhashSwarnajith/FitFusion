package lk.fitfusion.fitfusion_api.dto.response;

import lk.fitfusion.fitfusion_api.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponseDTO {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    private Role role;
}
