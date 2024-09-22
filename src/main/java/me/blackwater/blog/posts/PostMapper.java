package me.blackwater.blog.posts;

import me.blackwater.blog.posts.dto.PostDto;
import org.springframework.stereotype.Component;

@Component
class PostMapper {

    PostDto mapPostToPostDto(Post post){

        return new PostDto(post.getAuthorName(),post.getTitle(),post.getContext(),post.getLikes());
    }
}
