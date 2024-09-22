package me.blackwater.blog.posts;

import lombok.RequiredArgsConstructor;
import me.blackwater.blog.posts.dto.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
class PostController {

    private final PostService postService;
    private final PostMapper postMapper;

    @GetMapping("/author/{authorName}")
    ResponseEntity<List<PostDto>> getPostsByAuthorName(@PathVariable String authorName){
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostsByAuthorName(authorName).stream().map(postMapper::mapPostToPostDto).collect(Collectors.toList()));
    }
}
