package moskaliuk.project.blog.dto;

import lombok.Data;

@Data
public class CommentRequest {
    private String content;

    private Long author_id;

    private Long post_id;
}
