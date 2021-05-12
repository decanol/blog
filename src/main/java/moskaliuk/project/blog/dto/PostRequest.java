package moskaliuk.project.blog.dto;

import lombok.Data;

import java.util.Set;

@Data
public class PostRequest {
    private String title;

    private String content;

    private Long category_id;

    private Long author_id;

    private Set<Long> tags;
}
