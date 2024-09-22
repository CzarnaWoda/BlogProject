package me.blackwater.blog.sites;


import me.blackwater.blog.sites.dto.SiteDto;
import org.springframework.stereotype.Component;

@Component
class SiteMapper {


    SiteDto mapSiteToSiteDto(Site site){

        return new SiteDto(site.getAuthor(),site.getViews());


    }
}
