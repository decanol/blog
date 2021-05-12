package moskaliuk.project.blog.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String email;

    private String login;

    private String password;
}
