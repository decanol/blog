package moskaliuk.project.blog.controller;

import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.UserDTO;
import moskaliuk.project.blog.dto.UserRequest;
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
                                @RequestParam(required = false, defaultValue = "1") Integer page) {
        return service.findAll(page, size);
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public UserDTO create(@RequestBody UserRequest userRequest) {
        return service.create(userRequest);
    }

    @PutMapping("{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserRequest userRequest){
        return service.update(id, userRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        service.delete(id);
    }
}
