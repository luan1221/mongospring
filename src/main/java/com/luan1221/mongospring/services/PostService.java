package com.luan1221.mongospring.services;

import com.luan1221.mongospring.domain.Post;
import com.luan1221.mongospring.repositories.PostRepository;
import com.luan1221.mongospring.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository postRepository) {
        this.repository = postRepository;
    }

    public Post findById(String id) {
        Optional<Post> optionalPost = repository.findById(id);
        return optionalPost.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }
}
