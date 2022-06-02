package com.luan1221.mongospring.resources;

import com.luan1221.mongospring.domain.Post;
import com.luan1221.mongospring.resources.util.URL;
import com.luan1221.mongospring.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {

    private final PostService service;

    public PostResource(PostService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        return ResponseEntity.ok().body(service.findByTitle(URL.decodeParam(text)));
    }

}
