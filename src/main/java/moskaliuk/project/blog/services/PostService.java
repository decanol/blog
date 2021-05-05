package moskaliuk.project.blog.services;

import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.PostDTO;
import moskaliuk.project.blog.entity.Category;
import moskaliuk.project.blog.entity.Comment;
import moskaliuk.project.blog.entity.Post;
import moskaliuk.project.blog.entity.Tag;
import moskaliuk.project.blog.repos.CategoryRepository;
import moskaliuk.project.blog.repos.PostRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repo;

    public PostDTO getById(Long id) {
        var post =  repo.findById(id).orElseThrow();
        return map(post);
    }

    public List<PostDTO> findAll(Integer page, Integer size) {
        var paging = PageRequest.of(page, size);
        return repo.findAll(paging).stream().map(this::map).collect(Collectors.toList());
    }

    private PostDTO map(Post post){
        var postObj = new PostDTO();
        postObj.setId(post.getId());
        postObj.setTitle(post.getTitle());
        postObj.setContent(post.getContent());
        if (post.getAuthor() != null) {
            postObj.setAuthor_id(post.getAuthor().getId());
        }

        if(post.getCategory() != null) {
            postObj.setCategory_id(post.getCategory().getId());
        }
        postObj.setComments(post.getComments().stream().map(Comment::getId).collect(Collectors.toSet()));
        postObj.setTags(post.getTags().stream().map(Tag::getId).collect(Collectors.toSet()));

        return postObj;
    }
}
