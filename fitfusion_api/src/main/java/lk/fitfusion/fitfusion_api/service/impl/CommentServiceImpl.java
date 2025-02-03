package lk.fitfusion.fitfusion_api.service.impl;

import lk.fitfusion.fitfusion_api.model.Comment;
import lk.fitfusion.fitfusion_api.repository.CommentRepository;
import lk.fitfusion.fitfusion_api.service.CommentService;
import lk.fitfusion.fitfusion_api.service.PostService;
import lk.fitfusion.fitfusion_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;

    @Override
    public Comment createComment(Comment comment, String postId, String userId) {
        return null;
    }

    @Override
    public Comment findCommentById(String commentId) {
        return null;
    }

    @Override
    public Comment likeComment(String commentId, String userId) {
        return null;
    }

    @Override
    public List<Comment> getComments() {
        return List.of();
    }
}
