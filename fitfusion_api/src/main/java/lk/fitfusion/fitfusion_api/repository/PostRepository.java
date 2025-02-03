package lk.fitfusion.fitfusion_api.repository;

import lk.fitfusion.fitfusion_api.model.Post;
import lk.fitfusion.fitfusion_api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends MongoRepository<Post, String> {
    Optional<Post> findByUserId(String userId);
//    List<Post> findByUser(User user);
}
