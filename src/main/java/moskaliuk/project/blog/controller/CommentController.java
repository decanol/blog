package moskaliuk.project.blog.controller;

import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.CommentDTO;
import moskaliuk.project.blog.dto.CommentRequest;
import moskaliuk.project.blog.entity.Comment;
import moskaliuk.project.blog.services.CategoryService;
import moskaliuk.project.blog.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService service;

    @GetMapping()
    public List<CommentDTO> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                   @RequestParam(required = false, defaultValue = "1") Integer page) {
        return service.findAll(page, size);
    }

    @GetMapping("/{id}")
    public CommentDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public CommentDTO create(@RequestBody CommentRequest comment) {
        return service.create(comment);
    }

    @PutMapping("{id}")
    public CommentDTO update(@PathVariable Long id, @RequestBody CommentRequest commentRequest) {
        return service.update(id, commentRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        service.delete(id);
    }
}
