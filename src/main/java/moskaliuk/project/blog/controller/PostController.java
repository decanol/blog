package moskaliuk.project.blog.controller;

import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.PostDTO;
import moskaliuk.project.blog.dto.PostRequest;
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
    public PostDTO getById(@PathVariable Long id){
        return service.getById(id);
    }
    @PostMapping
    public PostDTO create(@RequestBody PostRequest postRequest){
        return service.create(postRequest);
    }
    @PutMapping("{id}")
    public PostDTO update(@PathVariable Long id, @RequestBody PostRequest postRequest){
        return service.update(id, postRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(Long id) {
        service.delete(id);
    }
}
