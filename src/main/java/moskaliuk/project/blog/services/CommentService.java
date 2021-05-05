package moskaliuk.project.blog.services;

import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.CommentDTO;
import moskaliuk.project.blog.dto.PostDTO;
import moskaliuk.project.blog.entity.Comment;
import moskaliuk.project.blog.entity.Post;
import moskaliuk.project.blog.entity.Tag;
import moskaliuk.project.blog.repos.CommentRepository;
import moskaliuk.project.blog.repos.PostRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository repo;

    public CommentDTO getById(Long id) {
        var comment = repo.findById(id).orElseThrow();
        return map(comment);
    }

    public List<CommentDTO> findAll(Integer page, Integer size) {
        var paging = PageRequest.of(page, size);
        return repo.findAll(paging).stream().map(this::map).collect(Collectors.toList());
    }

    private CommentDTO map(Comment comment){
        var commentObj = new CommentDTO();
        commentObj.setId(comment.getId());
        commentObj.setContent(comment.getContent());
        if (comment.getAuthor() != null) {
            commentObj.setAuthor_id(comment.getAuthor().getId());
        }

        if(comment.getPost() != null) {
            commentObj.setPost_id(comment.getPost().getId());
        }

        return commentObj;
    }
}
