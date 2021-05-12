package moskaliuk.project.blog.mapper;


import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.CategoryDTO;
import moskaliuk.project.blog.dto.CategoryRequest;
import moskaliuk.project.blog.entity.Category;
import moskaliuk.project.blog.repos.CategoryRepository;
import moskaliuk.project.blog.services.CategoryService;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class CategoryMapper {
    private final CategoryRepository repo;

    public Category fromRequest(CategoryRequest request) {
        var b = Category.builder()
                .id(new Random().nextLong())
                .description(request.getDescription())
                .name(request.getName());

        if (request.getParent() != 0) {
            b.parent(repo.findById(request.getParent()).orElseThrow());
        }

        return b.build();
    }
}