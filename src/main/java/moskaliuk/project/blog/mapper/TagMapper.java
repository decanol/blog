package moskaliuk.project.blog.mapper;


import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.PostRequest;
import moskaliuk.project.blog.dto.TagRequest;
import moskaliuk.project.blog.entity.Post;
import moskaliuk.project.blog.entity.Tag;
import moskaliuk.project.blog.repos.TagRepository;
import moskaliuk.project.blog.repos.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TagMapper {
    public Tag fromRequest(TagRequest request) {
        var tag = Tag.builder()
                .id(new Random().nextLong())
                .name(request.getName());

        return tag.build();
    }

    public Tag updateFromRequest(Tag tag, TagRequest request) {
        tag.setName(request.getName());
        return tag;
    }
}