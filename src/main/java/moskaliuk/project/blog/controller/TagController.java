package moskaliuk.project.blog.controller;

import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.TagDTO;
import moskaliuk.project.blog.entity.Tag;
import moskaliuk.project.blog.services.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagController {
    private final TagService service;

    @GetMapping()
    public List<TagDTO> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                               @RequestParam(required = false, defaultValue = "1") Integer page){
        return service.findAll(page,size);
    }

    @GetMapping("/{id}")
    public TagDTO getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public Tag create(@RequestBody Tag category){
        return null;
    }
    @PutMapping("{id}")
    public Tag update(@PathVariable Long id, @RequestBody Tag category){
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(Long id) {}
}
