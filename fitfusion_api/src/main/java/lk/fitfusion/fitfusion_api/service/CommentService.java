package lk.fitfusion.fitfusion_api.service;

import lk.fitfusion.fitfusion_api.model.Comment;

import java.util.List;

public interface CommentService {

    public Comment createComment(Comment comment,String postId,String userId);
    public Comment findCommentById(String commentId);
    public Comment likeComment(String commentId,String userId);
    public List<Comment> getComments();

}
