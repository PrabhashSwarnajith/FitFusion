package lk.fitfusion.fitfusion_api.repository;

import lk.fitfusion.fitfusion_api.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CommentRepository extends MongoRepository<Comment, String> {
}
