package moskaliuk.project.blog.dto;

import lombok.Data;
import java.util.Set;

@Data
public class CategoryDTO {
    private long id;

    private String name;
    private String description;

    private Long parent;

    private Set<Long> children;

    private Set<Long> posts;
}
