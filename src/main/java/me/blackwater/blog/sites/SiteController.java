package me.blackwater.blog.sites;

import lombok.RequiredArgsConstructor;
import me.blackwater.blog.sites.dto.SiteDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/site")
class SiteController {

    private final SiteServiceImpl service;
    private final SiteMapper mapper;

    @PostMapping("/create")
    ResponseEntity<SiteDto> createSite(@RequestBody CreateSiteRequest createSiteRequest){

        final Site site = service.createSite(createSiteRequest);

        return ResponseEntity.status(OK).body(mapper.mapSiteToSiteDto(site));
    }

    @GetMapping("/id/{id}")
    ResponseEntity<SiteDto> getSiteById(@PathVariable int id){
        final Optional<Site> siteOptional = service.getSiteById(id);
        return siteOptional.map(site -> ResponseEntity.status(OK).body(mapper.mapSiteToSiteDto(site))).orElseGet(() -> ResponseEntity.status(BAD_REQUEST).body(null));
    }

    @GetMapping("/author/{authorName}")
    ResponseEntity<List<SiteDto>> getSitesByAuthorName(@PathVariable String authorName){
        final List<Site> sites = service.getSitesByAuthorName(authorName);

        return ResponseEntity.status(OK).body(sites.stream().map(mapper::mapSiteToSiteDto).collect(Collectors.toList()));
    }

    @PostMapping("/post")
    ResponseEntity<String> createPost(@RequestBody CreatePostRequest createPostRequest){
        return ResponseEntity.status(OK).body(service.createPost(createPostRequest));
    }
}
