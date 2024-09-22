package me.blackwater.blog.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface PostRepository extends JpaRepository<Post,Long> {


    Optional<Post> getById(long id);

    List<Post> getByAuthorName(String authorName);


}
