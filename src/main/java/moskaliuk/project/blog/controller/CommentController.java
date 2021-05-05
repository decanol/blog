package moskaliuk.project.blog.controller;

import moskaliuk.project.blog.dto.CommentDTO;
import moskaliuk.project.blog.entity.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @GetMapping()
    public List<CommentDTO> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                @RequestParam(required = false, defaultValue = "1") Integer page){
        return null;
    }
    @GetMapping("/{id}")
    public CommentDTO getById(@PathVariable Long id){
        return null;
    }
    @PostMapping
    public Comment create(@RequestBody Comment comment){
        return null;
    }
    @PutMapping("{id}")
    public Comment update(@PathVariable Long id, @RequestBody Comment comment){
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(Long id) {}
}
