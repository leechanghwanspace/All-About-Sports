package com.allaboutsports.AaS.Controller;

import com.allaboutsports.AaS.Model.Post;
import com.allaboutsports.AaS.Service.CommentService;
import com.allaboutsports.AaS.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @GetMapping
    public String getAllPosts(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        int pageSize = 10000; // 페이지 당 게시글 수
        Page<Post> postPage = postService.getPosts(PageRequest.of(page - 1, pageSize));
        model.addAttribute("posts", postPage.getContent());
        model.addAttribute("totalPages", postPage.getTotalPages());
        return "community"; // community.html로 리턴
    }

    @PostMapping
    public String createPost(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        postService.savePost(post);
        return "redirect:/posts";
    }

    @GetMapping("/{postId}")
    public String getPost(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);
        return "post"; // post.html로 리턴
    }

    @PostMapping("/{postId}/comments")
    public String addComment(@PathVariable("postId") Long postId,
                             @RequestParam("author") String author,
                             @RequestParam("content") String content) {
        commentService.addComment(postId, author, content);
        return "redirect:/posts/" + postId;
    }
}
