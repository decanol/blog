package moskaliuk.project.blog.services;

import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.CommentDTO;
import moskaliuk.project.blog.dto.TagDTO;
import moskaliuk.project.blog.entity.Comment;
import moskaliuk.project.blog.entity.Tag;
import moskaliuk.project.blog.repos.CommentRepository;
import moskaliuk.project.blog.repos.TagRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository repo;

    public TagDTO getById(Long id) {
        var tag = repo.findById(id).orElseThrow();
        return map(tag);
    }

    public List<TagDTO> findAll(Integer page, Integer size) {
        var paging = PageRequest.of(page, size);
        return repo.findAll(paging).stream().map(this::map).collect(Collectors.toList());
    }

    private TagDTO map(Tag tag){
        var tagObj = new TagDTO();
        tagObj.setId(tag.getId());
        tagObj.setName(tag.getName());

        return tagObj;
    }
}
