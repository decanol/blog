package moskaliuk.project.blog.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    private long id;

    private String name;
}
