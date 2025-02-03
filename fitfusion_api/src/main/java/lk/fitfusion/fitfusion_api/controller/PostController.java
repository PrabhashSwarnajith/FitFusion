package lk.fitfusion.fitfusion_api.controller;

import lk.fitfusion.fitfusion_api.dto.request.PostRequestDTO;
import lk.fitfusion.fitfusion_api.dto.response.ApiResponseDTO;
import lk.fitfusion.fitfusion_api.dto.response.PostResponseDTO;
import lk.fitfusion.fitfusion_api.model.Post;
import lk.fitfusion.fitfusion_api.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/posts/")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private final PostService postService;

    @PostMapping("/user")
    public Post addPost(@RequestHeader ("Authorization")String jwt,@RequestBody PostRequestDTO postRequestDTO) {
        return postService.addPost(jwt,postRequestDTO);
    }

    @DeleteMapping("/{postId}")
    public ApiResponseDTO deletePost(@RequestHeader ("Authorization")String jwt,@PathVariable String postId) {
        return postService.deletePost(jwt, postId);
    }

    @GetMapping("/{postId}")
    public List<Post> findPostsByHandler(@PathVariable String postId) {
        return null;
    }

    @GetMapping("/{postId}/user/{userId}")
    public List<Post> findUsersPost(@PathVariable String userId ,@RequestParam String postId) {
        return null;
    }

    @GetMapping("/")
    public List<Post> findAllPosts() {
        return postService.findAllPosts();
    }


    @PutMapping("/save/{postId}")
    public ResponseEntity<List<Post>> savePostHandler(@RequestHeader ("Authorization")String jwt,@RequestParam String postId) {
        Post savePost = postService.savePost(postId,jwt);
        return null;
    }

    @PutMapping("/like/{postId}/")
    public List<PostResponseDTO> likePostHandler(@RequestHeader ("Authorization")String jwt,@RequestParam String postId) {
        return null;
    }


}
