package moskaliuk.project.blog.mapper;


import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.TagRequest;
import moskaliuk.project.blog.dto.UserRequest;
import moskaliuk.project.blog.entity.Tag;
import moskaliuk.project.blog.entity.User;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class UserMapper {
    public User fromRequest(UserRequest request) {
        var user = User.builder()
                .id(new Random().nextLong())
                .email(request.getEmail())
                .login(request.getLogin())
                .password(request.getPassword());

        return user.build();
    }

    public User updateFromRequest(User user, UserRequest request) {
        user.setEmail(request.getEmail());
        user.setLogin(request.getLogin());
        user.setPassword(request.getPassword());
        return user;
    }
}