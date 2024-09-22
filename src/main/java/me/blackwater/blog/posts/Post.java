package me.blackwater.blog.posts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private final long versionId = 1;

    private String authorName;

    private String title;

    private String context;

    private int likes;

    public Post(String authorName, String title, String context, int likes) {
        this.authorName = authorName;
        this.title = title;
        this.context = context;
        this.likes = likes;
    }
}
