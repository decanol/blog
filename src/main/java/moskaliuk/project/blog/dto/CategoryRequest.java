package moskaliuk.project.blog.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CategoryRequest {
    private String name;
    private String description;

    private Long parent;
}
