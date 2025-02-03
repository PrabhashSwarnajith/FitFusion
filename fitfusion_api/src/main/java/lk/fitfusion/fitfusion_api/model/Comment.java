package lk.fitfusion.fitfusion_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "comments")
@Data
public class Comment {
    @Id
    private String id;

    @DBRef
    private User user;
    private String comment;
    @DBRef
    private List<User> likes=new ArrayList<>();

    private LocalDateTime createdAt;
}
