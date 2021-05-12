package moskaliuk.project.blog.services;

import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.TagDTO;
import moskaliuk.project.blog.dto.UserDTO;
import moskaliuk.project.blog.dto.UserRequest;
import moskaliuk.project.blog.entity.Tag;
import moskaliuk.project.blog.entity.User;
import moskaliuk.project.blog.mapper.UserMapper;
import moskaliuk.project.blog.repos.TagRepository;
import moskaliuk.project.blog.repos.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo;
    private final UserMapper mapper;

    public UserDTO getById(Long id) {
        var user = repo.findById(id).orElseThrow();
        return map(user);
    }

    public List<UserDTO> findAll(Integer page, Integer size) {
        var paging = PageRequest.of(page, size);
        return repo.findAll(paging).stream().map(this::map).collect(Collectors.toList());
    }

    public UserDTO create(UserRequest userRequest) {
        var user = mapper.fromRequest(userRequest);

        return map(repo.save(user));
    }

    public UserDTO update(Long id, UserRequest userRequest) {
        var user = mapper.updateFromRequest(repo.findById(id).orElseThrow(), userRequest);

        return map(repo.save(user));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private UserDTO map(User user) {
        var userObj = new UserDTO();
        userObj.setId(user.getId());
        userObj.setEmail(user.getEmail());
        userObj.setLogin(user.getLogin());

        return userObj;
    }
}
