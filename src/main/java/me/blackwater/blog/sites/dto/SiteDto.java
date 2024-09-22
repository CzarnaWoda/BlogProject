package me.blackwater.blog.sites.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SiteDto {

    private String author;

    private int views;


    public SiteDto(String author, int views) {
        this.author = author;
        this.views = views;
    }
}
