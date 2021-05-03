package moskaliuk.project.blog.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "users")
public class User {
    @Id
    private Long id;

    private String email;

    private String login;

    private String password;



}
