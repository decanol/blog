package moskaliuk.project.blog.controller;

import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.PostDTO;
import moskaliuk.project.blog.entity.Post;
import moskaliuk.project.blog.services.CategoryService;
import moskaliuk.project.blog.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService service;

    @GetMapping
    public List<PostDTO> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                @RequestParam(required = false, defaultValue = "1") Integer page){
        return service.findAll(page, size);
    }
    @GetMapping("/{id}")
    public List<Post> getAll(@PathVariable Long id){
        return null;
    }
    @PostMapping
    public Post create(@RequestBody Post post){
        return null;
    }
    @PutMapping("{id}")
    public Post update(@PathVariable Long id, @RequestBody Post post){
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(Long id) {}
}
