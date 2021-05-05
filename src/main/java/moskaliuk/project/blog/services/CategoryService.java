package moskaliuk.project.blog.services;

import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.CategoryDTO;
import moskaliuk.project.blog.entity.Category;
import moskaliuk.project.blog.entity.Post;
import moskaliuk.project.blog.repos.CategoryRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repo;

    public CategoryDTO getById(Long id) {
        var category =  repo.findById(id).orElseThrow();
        return map(category);
    }

    public List<CategoryDTO> findAll(Integer page, Integer size) {
        var paging = PageRequest.of(page, size);
        return repo.findAll(paging).stream().map(this::map).collect(Collectors.toList());
    }

    private CategoryDTO map(Category category){
        var a = new CategoryDTO();
        a.setId(category.getId());
        a.setName(category.getName());
        a.setDescription(category.getDescription());
        if (category.getParent() != null) {
            a.setParent(category.getParent().getId());
        }
        a.setChildren(category.getChildren().stream().map(Category::getId).collect(Collectors.toSet()));
        a.setPosts(category.getPosts().stream().map(Post::getId).collect(Collectors.toSet()));

        return a;
    }
}
