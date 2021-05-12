package moskaliuk.project.blog.services;

import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.PostDTO;
import moskaliuk.project.blog.dto.PostRequest;
import moskaliuk.project.blog.entity.Category;
import moskaliuk.project.blog.entity.Comment;
import moskaliuk.project.blog.entity.Post;
import moskaliuk.project.blog.entity.Tag;
import moskaliuk.project.blog.mapper.PostMapper;
import moskaliuk.project.blog.repos.CategoryRepository;
import moskaliuk.project.blog.repos.PostRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repo;
    private final PostMapper mapper;

    public PostDTO getById(Long id) {
        var post = repo.findById(id).orElseThrow();
        return map(post);
    }

    public List<PostDTO> findAll(Integer page, Integer size) {
        var paging = PageRequest.of(page, size);
        return repo.findAll(paging).stream().map(this::map).collect(Collectors.toList());
    }

    public PostDTO create(PostRequest postRequest) {
        var post = mapper.fromRequest(postRequest);

        return map(repo.save(post));
    }

    public PostDTO update(Long id, PostRequest postRequest) {
        var post = mapper.updateFromRequest(repo.findById(id).orElseThrow(), postRequest);

        return map(repo.save(post));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private PostDTO map(Post post) {
        var postObj = new PostDTO();
        postObj.setId(post.getId());
        postObj.setTitle(post.getTitle());
        postObj.setContent(post.getContent());
        if (post.getAuthor() != null) {
            postObj.setAuthor_id(post.getAuthor().getId());
        }

        if (post.getCategory() != null) {
            postObj.setCategory_id(post.getCategory().getId());
        }
        if(post.getComments() != null) {
            postObj.setComments(post.getComments().stream().map(Comment::getId).collect(Collectors.toSet()));
        }
        if(post.getTags() != null) {
            postObj.setTags(post.getTags().stream().map(Tag::getId).collect(Collectors.toSet()));
        }
        return postObj;
    }
}
