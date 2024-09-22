package me.blackwater.blog.sites;

import java.util.List;
import java.util.Optional;

interface SiteService {
     Optional<Site> getSiteById(long id);

    List<Site> getSitesByAuthorName(String authorName);

    Site createSite(CreateSiteRequest createSiteRequest);

    String createPost(CreatePostRequest createPostRequest);
}
