package moskaliuk.project.blog.controller;

import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.TagDTO;
import moskaliuk.project.blog.dto.TagRequest;
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
                               @RequestParam(required = false, defaultValue = "1") Integer page) {
        return service.findAll(page, size);
    }

    @GetMapping("/{id}")
    public TagDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public TagDTO create(@RequestBody TagRequest tagRequest) {
        return service.create(tagRequest);
    }

    @PutMapping("{id}")
    public TagDTO update(@PathVariable Long id, @RequestBody TagRequest tagRequest) {
        return service.update(id, tagRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        service.delete(id);
    }
}
