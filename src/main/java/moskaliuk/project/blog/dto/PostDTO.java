package moskaliuk.project.blog.dto;

import lombok.Data;
import moskaliuk.project.blog.entity.Category;
import moskaliuk.project.blog.entity.Comment;
import moskaliuk.project.blog.entity.Tag;
import moskaliuk.project.blog.entity.User;

import javax.persistence.*;
import java.util.Set;

@Data
public class PostDTO {
    private Long id;

    private String title;

    private String content;

    private Long category_id;

    private Long author_id;

    private Set<Long> comments;

    private Set<Long> tags;
}
