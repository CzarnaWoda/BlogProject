package me.blackwater.blog.posts;

import me.blackwater.blog.events.CreatePostEvent;

import java.util.List;
import java.util.Optional;

interface PostService {

    Optional<Post> getPostById(long id);

    List<Post> getPostsByAuthorName(String authorName);

    void onCreatePostEvent(CreatePostEvent event);
}
