package me.blackwater.blog.sites;


import lombok.RequiredArgsConstructor;
import me.blackwater.blog.events.CreatePostEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class SiteServiceImpl implements SiteService{

    private final SiteRepository siteRepository;
    private final ApplicationEventPublisher applicationEventPublisher;


    @Override
    public Optional<Site> getSiteById(long id){
        return siteRepository.getById(id);
    }

    @Override
    public List<Site> getSitesByAuthorName(String authorName){
        return siteRepository.getSitesByAuthor(authorName);
    }

    @Override
    public Site createSite(CreateSiteRequest createSiteRequest){
        return siteRepository.save(new Site(createSiteRequest.authorName(),0));
    }

    @Override
    @Transactional
    public String createPost(CreatePostRequest createPostRequest) {
        if(getSitesByAuthorName(createPostRequest.authorName()).isEmpty()){
            return "Author doesn't have any sites";
        }else {
            applicationEventPublisher.publishEvent(new CreatePostEvent(createPostRequest.authorName(), createPostRequest.title(), createPostRequest.context()));

            return "Publish event to create a post";
        }
    }
}
