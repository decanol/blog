package moskaliuk.project.blog.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    private long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Category parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Category> children;

    @OneToMany(mappedBy = "category")
    private Set<Post> posts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id && Objects.equals(name, category.name) && Objects.equals(description, category.description) && Objects.equals(children, category.children) && Objects.equals(posts, category.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, children, posts);
    }
}