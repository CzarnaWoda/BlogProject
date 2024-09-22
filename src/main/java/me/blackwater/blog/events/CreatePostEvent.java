package me.blackwater.blog.events;

public record CreatePostEvent(
        String authorName,
        String title,
        String context
) {


}
