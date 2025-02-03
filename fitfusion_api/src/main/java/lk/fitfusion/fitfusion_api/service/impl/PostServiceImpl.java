package lk.fitfusion.fitfusion_api.service.impl;

import lk.fitfusion.fitfusion_api.dto.request.PostRequestDTO;
import lk.fitfusion.fitfusion_api.dto.response.ApiResponseDTO;
import lk.fitfusion.fitfusion_api.dto.response.PostResponseDTO;
import lk.fitfusion.fitfusion_api.model.Post;
import lk.fitfusion.fitfusion_api.model.User;
import lk.fitfusion.fitfusion_api.repository.PostRepository;
import lk.fitfusion.fitfusion_api.repository.UserRepository;
import lk.fitfusion.fitfusion_api.service.PostService;
import lk.fitfusion.fitfusion_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public Post addPost(String jwt,PostRequestDTO postRequestDTO) {

        User username = userService.findUserByJwt(jwt);

        if (username == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }
        Optional<User> userOptional = userRepository.findByUsername(username.getUsername());
        if (userOptional.isPresent()) {

            Post post = new Post();

            post.setUserId(username.getId()); // Assuming userId is the ID of the user
            post.setDescription(postRequestDTO.getDescription());
            post.setVideo(postRequestDTO.getVideo());
            post.setImage(postRequestDTO.getImage());
            post.setCreatedAt(LocalDateTime.now());

            // Add the post to the user's list of posts
            username.getPosts().add(post);
            postRepository.save(post);

            // Save the updated user
            userRepository.save(username);
            return post;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found for provided userId");
        }
    }

    @Override
    public List<Post> findPostsByUserId(String jwt) {
        return List.of();
    }

    @Override
    public ApiResponseDTO deletePost(String jwt, String postId) {
        User user = userService.findUserByJwt(jwt);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }
        Optional<Post> postOptional = postRepository.findById(postId);

        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            postRepository.delete(post);
            return new ApiResponseDTO("Post deleted successfully");
        } else {
            // Handle the case where the post doesn't exist
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        }
    }

//    @Override
//    public List<Post> findPostsById(String postId) {
//        return List.of();
//    }

    @Override
    public List<Post> findAllPosts() {
        return List.of();
    }

    @Override
    public Post savePost(String postId, String jwt) {
        return null;
    }

    @Override
    public Post likePost(String postId, String jwt) {
        return null;
    }

}

