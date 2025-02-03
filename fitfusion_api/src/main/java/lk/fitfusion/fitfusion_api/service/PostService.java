package lk.fitfusion.fitfusion_api.service;

import lk.fitfusion.fitfusion_api.dto.request.PostRequestDTO;
import lk.fitfusion.fitfusion_api.dto.response.ApiResponseDTO;
import lk.fitfusion.fitfusion_api.dto.response.PostResponseDTO;
import lk.fitfusion.fitfusion_api.model.Post;


import java.util.List;

public interface PostService {

    Post addPost(String jwt,PostRequestDTO postRequestDTO);
    List<Post> findPostsByUserId(String jwt);
    ApiResponseDTO deletePost(String jwt,String postId) ;
    List<Post> findAllPosts();
    Post savePost(String postId,String jwt);
    Post likePost(String postId, String jwt);

}
