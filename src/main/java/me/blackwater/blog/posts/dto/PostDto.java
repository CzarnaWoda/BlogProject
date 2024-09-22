package me.blackwater.blog.posts.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PostDto {

    private final String authorName;

    private final String title;

    private final String context;

    private final int likes;
}
