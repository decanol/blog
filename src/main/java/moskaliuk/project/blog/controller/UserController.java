package moskaliuk.project.blog.controller;

import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.UserDTO;
import moskaliuk.project.blog.entity.User;
import moskaliuk.project.blog.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    @GetMapping
    public List<UserDTO> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                @RequestParam(required = false, defaultValue = "1") Integer page){
        return service.findAll(page, size);
    }
    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user){
        return null;
    }
    @PutMapping("{id}")
    public User update(@PathVariable Long id, @RequestBody User user){
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(Long id) {}
}
