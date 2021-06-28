package de.web.selfcare.controller;

import de.web.selfcare.models.Post;
import de.web.selfcare.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<Post> getAllPosts() {
        return (List<Post>) postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postRepository.findById(id).orElse(new Post());
    }

    @GetMapping(value = "/{id}/bild",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImageOfPost(@PathVariable(value = "id") Long id) {

        Post post =  postRepository.findById(id).orElse(new Post());
        String bild = "/Users/cumali/Documents/Studium/WEB/selfcare/src/main/resources/static/uploads/"+id;
        Path path = Paths.get(bild);
        try {
            return Files.readAllBytes(path);
        } catch(IOException e) {
            System.out.println(e);
            return null;
        }
    }
}
