package me.blackwater.blog.sites;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface SiteRepository extends JpaRepository<Site, Long> {


    Optional<Site> getById(long id);

    List<Site> getSitesByAuthor(String authorName);
}
