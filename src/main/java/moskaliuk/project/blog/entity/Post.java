package moskaliuk.project.blog.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@Entity(name = "posts")
public class Post {
    @Id
    private Long id;

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany
    @JoinColumn(name = "post_id")
    private Set<Comment> comments;


    @ManyToMany
    @JoinTable(name = "post_tags",
        joinColumns = {
            @JoinColumn(name = "post_id", referencedColumnName = "id"),
        },
        inverseJoinColumns = {
            @JoinColumn(name = "tag_id", referencedColumnName = "id"),
        }
    )
    private Set<Tag> tags;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(content, post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content);
    }
}
