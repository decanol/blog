package moskaliuk.project.blog.services;

import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.CommentDTO;
import moskaliuk.project.blog.dto.TagDTO;
import moskaliuk.project.blog.dto.TagRequest;
import moskaliuk.project.blog.entity.Comment;
import moskaliuk.project.blog.entity.Tag;
import moskaliuk.project.blog.mapper.TagMapper;
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
    private final TagMapper mapper;

    public TagDTO getById(Long id) {
        var tag = repo.findById(id).orElseThrow();
        return map(tag);
    }

    public List<TagDTO> findAll(Integer page, Integer size) {
        var paging = PageRequest.of(page, size);
        return repo.findAll(paging).stream().map(this::map).collect(Collectors.toList());
    }

    public TagDTO create(TagRequest tagRequest) {
        var tag = mapper.fromRequest(tagRequest);

        return map(repo.save(tag));
    }

    public TagDTO update(Long id, TagRequest tagRequest) {
        var tag = mapper.updateFromRequest(repo.findById(id).orElseThrow(), tagRequest);

        return map(repo.save(tag));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private TagDTO map(Tag tag) {
        var tagObj = new TagDTO();
        tagObj.setId(tag.getId());
        tagObj.setName(tag.getName());

        return tagObj;
    }
}
