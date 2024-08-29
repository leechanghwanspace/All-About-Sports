package com.allaboutsports.AaS.Controller;

import com.allaboutsports.AaS.Model.MatchingPost;
import com.allaboutsports.AaS.Model.User;
import com.allaboutsports.AaS.Repository.MatchingPostRepository;
import com.allaboutsports.AaS.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/matching")
public class MatchingController {

    @Autowired
    private MatchingPostRepository matchingPostRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/golf")
    public String listGolfMatchingPosts(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<MatchingPost> posts = matchingPostRepository.findAll().stream()
                .filter(post -> "golf".equals(post.getCategory()))
                .collect(Collectors.toList());
        model.addAttribute("posts", posts);
        model.addAttribute("userEmail", userDetails.getUsername());
        return "golf_matching";
    }

    @GetMapping("/golf/new")
    public String createGolfMatchingPostForm(Model model) {
        model.addAttribute("post", new MatchingPost());
        return "golf_matching_form";
    }

    @PostMapping("/golf")
    public String createGolfMatchingPost(@ModelAttribute MatchingPost post, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        post.getMatchingMembers().add(user);
        post.setCategory("golf");
        post.setCreatedBy(userDetails.getUsername());
        post.setMaxMembers(4); // 골프 매칭 최대 인원 설정
        matchingPostRepository.save(post);
        return "redirect:/matching/golf";
    }

    @PostMapping("/golf/join/{id}")
    public String joinGolfMatching(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        MatchingPost post = matchingPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        if (!post.isClosed() && post.getMatchingMembers().size() < post.getMaxMembers() && !post.getMatchingMembers().contains(user)) {
            post.getMatchingMembers().add(user);
            if (post.getMatchingMembers().size() >= post.getMaxMembers()) {
                post.setClosed(true);
            }
            matchingPostRepository.save(post);
        }
        return "redirect:/matching/golf";
    }

    @PostMapping("/golf/close/{id}")
    public String closeGolfMatching(@PathVariable Long id) {
        MatchingPost post = matchingPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        post.setClosed(true);
        matchingPostRepository.save(post);
        return "redirect:/matching/golf";
    }

    // 유사하게 축구와 헬스 매칭에 대한 매핑 추가
    @GetMapping("/soccer")
    public String listSoccerMatchingPosts(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<MatchingPost> posts = matchingPostRepository.findAll().stream()
                .filter(post -> "soccer".equals(post.getCategory()))
                .collect(Collectors.toList());
        model.addAttribute("posts", posts);
        model.addAttribute("userEmail", userDetails.getUsername());
        return "soccer_matching";
    }

    @GetMapping("/soccer/new")
    public String createSoccerMatchingPostForm(Model model) {
        model.addAttribute("post", new MatchingPost());
        return "soccer_matching_form";
    }

    @PostMapping("/soccer")
    public String createSoccerMatchingPost(@ModelAttribute MatchingPost post, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        post.getMatchingMembers().add(user);
        post.setCategory("soccer");
        post.setCreatedBy(userDetails.getUsername());
        post.setMaxMembers(22); // 축구 매칭 최대 인원 설정 (11 vs 11)
        matchingPostRepository.save(post);
        return "redirect:/matching/soccer";
    }

    @PostMapping("/soccer/join/{id}")
    public String joinSoccerMatching(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        MatchingPost post = matchingPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        if (!post.isClosed() && post.getMatchingMembers().size() < post.getMaxMembers() && !post.getMatchingMembers().contains(user)) {
            post.getMatchingMembers().add(user);
            if (post.getMatchingMembers().size() >= post.getMaxMembers()) {
                post.setClosed(true);
            }
            matchingPostRepository.save(post);
        }
        return "redirect:/matching/soccer";
    }

    @PostMapping("/soccer/close/{id}")
    public String closeSoccerMatching(@PathVariable Long id) {
        MatchingPost post = matchingPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        post.setClosed(true);
        matchingPostRepository.save(post);
        return "redirect:/matching/soccer";
    }

    @GetMapping("/workout")
    public String listWorkoutMatchingPosts(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<MatchingPost> posts = matchingPostRepository.findAll().stream()
                .filter(post -> "workout".equals(post.getCategory()))
                .collect(Collectors.toList());
        model.addAttribute("posts", posts);
        model.addAttribute("userEmail", userDetails.getUsername());
        return "workout_matching";
    }

    @GetMapping("/workout/new")
    public String createWorkoutMatchingPostForm(Model model) {
        model.addAttribute("post", new MatchingPost());
        return "workout_matching_form";
    }

    @PostMapping("/workout")
    public String createWorkoutMatchingPost(@ModelAttribute MatchingPost post, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        post.getMatchingMembers().add(user);
        post.setCategory("workout");
        post.setCreatedBy(userDetails.getUsername());
        post.setMaxMembers(3); // 헬스 매칭 최대 인원 설정
        matchingPostRepository.save(post);
        return "redirect:/matching/workout";
    }

    @PostMapping("/workout/join/{id}")
    public String joinWorkoutMatching(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        MatchingPost post = matchingPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        if (!post.isClosed() && post.getMatchingMembers().size() < post.getMaxMembers() && !post.getMatchingMembers().contains(user)) {
            post.getMatchingMembers().add(user);
            if (post.getMatchingMembers().size() >= post.getMaxMembers()) {
                post.setClosed(true);
            }
            matchingPostRepository.save(post);
        }
        return "redirect:/matching/workout";
    }

    @PostMapping("/workout/close/{id}")
    public String closeWorkoutMatching(@PathVariable Long id) {
        MatchingPost post = matchingPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        post.setClosed(true);
        matchingPostRepository.save(post);
        return "redirect:/matching/workout";
    }
}
