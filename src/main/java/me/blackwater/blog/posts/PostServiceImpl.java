package me.blackwater.blog.posts;

import lombok.RequiredArgsConstructor;
import me.blackwater.blog.events.CreatePostEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public Optional<Post> getPostById(long id) {
        return postRepository.getById(id);
    }

    @Override
    public List<Post> getPostsByAuthorName(String authorName) {
        return postRepository.getByAuthorName(authorName);
    }

    @Override
    @EventListener
    public void onCreatePostEvent(CreatePostEvent event) {

        postRepository.save(new Post(event.authorName(),event.title(),event.context(),0));

        System.out.print("DEBUG #1");

    }
}
