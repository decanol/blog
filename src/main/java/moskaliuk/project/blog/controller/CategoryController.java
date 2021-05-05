package moskaliuk.project.blog.controller;

import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.CategoryDTO;
import moskaliuk.project.blog.entity.Category;
import moskaliuk.project.blog.entity.Post;
import moskaliuk.project.blog.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService service;

    @GetMapping()
    public List<CategoryDTO> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                    @RequestParam(required = false, defaultValue = "1") Integer page){
        return service.findAll(page, size);
    }
    @GetMapping("/{id}")
    public CategoryDTO getById(@PathVariable Long id){
        return service.getById(id);
    }
    @PostMapping
    public Category create(@RequestBody Category category){
        return null;
    }
    @PutMapping("{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category){
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(Long id) {}


    @GetMapping("/{categoryId}/posts")
    public List<Post> getPostsByCategory(@PathVariable Long categoryId){
        return null;
    }

}
