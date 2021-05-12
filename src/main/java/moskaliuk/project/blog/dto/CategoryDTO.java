package moskaliuk.project.blog.dto;

import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryDTO {
    private long id;

    private String name;
    private String description;

    private Long parent;

    private Set<Long> children = new HashSet<>();

    private Set<Long> posts = new HashSet<>();
}
