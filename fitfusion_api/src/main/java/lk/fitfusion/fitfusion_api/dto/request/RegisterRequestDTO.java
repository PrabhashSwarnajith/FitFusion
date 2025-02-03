package lk.fitfusion.fitfusion_api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequestDTO {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    private String password;
}
