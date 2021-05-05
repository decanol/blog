package moskaliuk.project.blog.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CommentDTO {
    private Long id;

    private String content;

    private Long author_id;

    private Long post_id;
}
