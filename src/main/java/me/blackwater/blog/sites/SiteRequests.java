package me.blackwater.blog.sites;

record CreateSiteRequest(

        String authorName
) {}

record CreatePostRequest(
        String authorName,
        String title,
        String context
){}
