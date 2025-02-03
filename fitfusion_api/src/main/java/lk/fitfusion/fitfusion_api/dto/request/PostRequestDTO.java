package lk.fitfusion.fitfusion_api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDTO {

    private List<String> image;
    private List<String> video;
    private String description;
}
