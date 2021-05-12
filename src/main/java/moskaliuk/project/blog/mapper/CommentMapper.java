package moskaliuk.project.blog.mapper;


import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.CategoryRequest;
import moskaliuk.project.blog.dto.CommentRequest;
import moskaliuk.project.blog.entity.Category;
import moskaliuk.project.blog.entity.Comment;
import moskaliuk.project.blog.repos.CategoryRepository;
import moskaliuk.project.blog.repos.CommentRepository;
import moskaliuk.project.blog.repos.PostRepository;
import moskaliuk.project.blog.repos.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class CommentMapper {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Comment fromRequest(CommentRequest request) {
        var comment = Comment.builder()
                .id(new Random().nextLong())
                .content(request.getContent())
                .author(userRepository.findById(request.getAuthor_id()).orElseThrow())
                .post(postRepository.findById(request.getPost_id()).orElseThrow());

        return comment.build();
    }

    public Comment updateFromRequest(Comment comment, CommentRequest request) {
        comment.setContent(request.getContent());
        comment.setAuthor(userRepository.findById(request.getAuthor_id()).orElseThrow());
        comment.setPost(postRepository.findById(request.getPost_id()).orElseThrow());
        return comment;
    }
}