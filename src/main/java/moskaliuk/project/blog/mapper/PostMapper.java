package moskaliuk.project.blog.mapper;


import lombok.RequiredArgsConstructor;
import moskaliuk.project.blog.dto.CommentRequest;
import moskaliuk.project.blog.dto.PostRequest;
import moskaliuk.project.blog.entity.Comment;
import moskaliuk.project.blog.entity.Post;
import moskaliuk.project.blog.repos.CategoryRepository;
import moskaliuk.project.blog.repos.PostRepository;
import moskaliuk.project.blog.repos.TagRepository;
import moskaliuk.project.blog.repos.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostMapper {
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final CategoryRepository categoryRepository;

    public Post fromRequest(PostRequest request) {
        var post = Post.builder()
                .id(new Random().nextLong())
                .content(request.getContent())
                .title(request.getTitle())
                .author(userRepository.findById(request.getAuthor_id()).orElseThrow())
                .tags(request.getTags().stream().map((id) -> tagRepository.findById(id).orElseThrow()).collect(Collectors.toSet()))
                .category(categoryRepository.findById(request.getCategory_id()).orElseThrow());

        return post.build();
    }

    public Post updateFromRequest(Post post, PostRequest request) {
        post.setContent(request.getContent());
        post.setTitle(request.getTitle());
        post.setAuthor(userRepository.findById(request.getAuthor_id()).orElseThrow());
        post.setTags(request.getTags().stream().map((id) -> tagRepository.findById(id).orElseThrow()).collect(Collectors.toSet()));
        post.setCategory(categoryRepository.findById(request.getCategory_id()).orElseThrow());
        return post;
    }
}