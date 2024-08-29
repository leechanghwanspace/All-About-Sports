package com.allaboutsports.AaS.Controller;

import com.allaboutsports.AaS.Model.CrewPost;
import com.allaboutsports.AaS.Model.User;
import com.allaboutsports.AaS.Repository.CrewPostRepository;
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
@RequestMapping("/crew")
public class CrewController {

    @Autowired
    private CrewPostRepository crewPostRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/soccer")
    public String listSoccerCrewPosts(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<CrewPost> posts = crewPostRepository.findAll().stream()
                .filter(post -> "soccer".equals(post.getCategory()))
                .collect(Collectors.toList());
        model.addAttribute("posts", posts);
        model.addAttribute("userEmail", userDetails.getUsername()); // 현재 유저의 이메일 전달
        return "soccer_crew";
    }

    @GetMapping("/soccer/new")
    public String createSoccerCrewPostForm(Model model) {
        model.addAttribute("post", new CrewPost());
        return "soccer_crew_form";
    }

    @PostMapping("/soccer")
    public String createSoccerCrewPost(@ModelAttribute CrewPost post, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        post.getCrewMembers().add(user);
        post.setCategory("soccer"); // 종목 설정
        post.setCreatedBy(userDetails.getUsername()); // 작성자 이메일 설정
        crewPostRepository.save(post);
        return "redirect:/crew/soccer";
    }

    @PostMapping("/soccer/join/{id}")
    public String joinSoccerCrew(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        CrewPost post = crewPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        if (!post.isClosed() && post.getCrewMembers().size() < post.getMaxMembers() && !post.getCrewMembers().contains(user)) {
            post.getCrewMembers().add(user);
            if (post.getCrewMembers().size() >= post.getMaxMembers()) {
                post.setClosed(true);
            }
            crewPostRepository.save(post);
        }
        return "redirect:/crew/soccer";
    }

    @PostMapping("/soccer/close/{id}")
    public String closeSoccerCrew(@PathVariable Long id) {
        CrewPost post = crewPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        post.setClosed(true);
        crewPostRepository.save(post);
        return "redirect:/crew/soccer";
    }

    // 유사하게 다른 크루에 대한 매핑 추가 (workout, diet_running, diet_hiking, diet_climbing)
    @GetMapping("/workout")
    public String listWorkoutCrewPosts(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<CrewPost> posts = crewPostRepository.findAll().stream()
                .filter(post -> "workout".equals(post.getCategory()))
                .collect(Collectors.toList());
        model.addAttribute("posts", posts);
        model.addAttribute("userEmail", userDetails.getUsername());
        return "workout_crew";
    }

    @GetMapping("/workout/new")
    public String createWorkoutCrewPostForm(Model model) {
        model.addAttribute("post", new CrewPost());
        return "workout_crew_form";
    }

    @PostMapping("/workout")
    public String createWorkoutCrewPost(@ModelAttribute CrewPost post, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        post.getCrewMembers().add(user);
        post.setCategory("workout"); // 종목 설정
        post.setCreatedBy(userDetails.getUsername()); // 작성자 이메일 설정
        crewPostRepository.save(post);
        return "redirect:/crew/workout";
    }

    @PostMapping("/workout/join/{id}")
    public String joinWorkoutCrew(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        CrewPost post = crewPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        if (!post.isClosed() && post.getCrewMembers().size() < post.getMaxMembers() && !post.getCrewMembers().contains(user)) {
            post.getCrewMembers().add(user);
            if (post.getCrewMembers().size() >= post.getMaxMembers()) {
                post.setClosed(true);
            }
            crewPostRepository.save(post);
        }
        return "redirect:/crew/workout";
    }

    @PostMapping("/workout/close/{id}")
    public String closeWorkoutCrew(@PathVariable Long id) {
        CrewPost post = crewPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        post.setClosed(true);
        crewPostRepository.save(post);
        return "redirect:/crew/workout";
    }

    // diet_runningCrew
    @GetMapping("/diet_running")
    public String listDietRunningCrewPosts(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<CrewPost> posts = crewPostRepository.findAll().stream()
                .filter(post -> "diet_running".equals(post.getCategory()))
                .collect(Collectors.toList());
        model.addAttribute("posts", posts);
        model.addAttribute("userEmail", userDetails.getUsername());
        return "diet_runningCrew";
    }

    @GetMapping("/diet_running/new")
    public String createDietRunningCrewPostForm(Model model) {
        model.addAttribute("post", new CrewPost());
        return "diet_runningCrew_form";
    }

    @PostMapping("/diet_running")
    public String createDietRunningCrewPost(@ModelAttribute CrewPost post, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        post.getCrewMembers().add(user);
        post.setCategory("diet_running"); // 종목 설정
        post.setCreatedBy(userDetails.getUsername()); // 작성자 이메일 설정
        crewPostRepository.save(post);
        return "redirect:/crew/diet_running";
    }

    @PostMapping("/diet_running/join/{id}")
    public String joinDietRunningCrew(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        CrewPost post = crewPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        if (!post.isClosed() && post.getCrewMembers().size() < post.getMaxMembers() && !post.getCrewMembers().contains(user)) {
            post.getCrewMembers().add(user);
            if (post.getCrewMembers().size() >= post.getMaxMembers()) {
                post.setClosed(true);
            }
            crewPostRepository.save(post);
        }
        return "redirect:/crew/diet_running";
    }

    @PostMapping("/diet_running/close/{id}")
    public String closeDietRunningCrew(@PathVariable Long id) {
        CrewPost post = crewPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        post.setClosed(true);
        crewPostRepository.save(post);
        return "redirect:/crew/diet_running";
    }

    // diet_hikingCrew
    @GetMapping("/diet_hiking")
    public String listDietHikingCrewPosts(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<CrewPost> posts = crewPostRepository.findAll().stream()
                .filter(post -> "diet_hiking".equals(post.getCategory()))
                .collect(Collectors.toList());
        model.addAttribute("posts", posts);
        model.addAttribute("userEmail", userDetails.getUsername());
        return "diet_hikingCrew";
    }

    @GetMapping("/diet_hiking/new")
    public String createDietHikingCrewPostForm(Model model) {
        model.addAttribute("post", new CrewPost());
        return "diet_hikingCrew_form";
    }

    @PostMapping("/diet_hiking")
    public String createDietHikingCrewPost(@ModelAttribute CrewPost post, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        post.getCrewMembers().add(user);
        post.setCategory("diet_hiking"); // 종목 설정
        post.setCreatedBy(userDetails.getUsername()); // 작성자 이메일 설정
        crewPostRepository.save(post);
        return "redirect:/crew/diet_hiking";
    }

    @PostMapping("/diet_hiking/join/{id}")
    public String joinDietHikingCrew(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        CrewPost post = crewPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        if (!post.isClosed() && post.getCrewMembers().size() < post.getMaxMembers() && !post.getCrewMembers().contains(user)) {
            post.getCrewMembers().add(user);
            if (post.getCrewMembers().size() >= post.getMaxMembers()) {
                post.setClosed(true);
            }
            crewPostRepository.save(post);
        }
        return "redirect:/crew/diet_hiking";
    }

    @PostMapping("/diet_hiking/close/{id}")
    public String closeDietHikingCrew(@PathVariable Long id) {
        CrewPost post = crewPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        post.setClosed(true);
        crewPostRepository.save(post);
        return "redirect:/crew/diet_hiking";
    }

    // diet_climbingCrew
    @GetMapping("/diet_climbing")
    public String listDietClimbingCrewPosts(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<CrewPost> posts = crewPostRepository.findAll().stream()
                .filter(post -> "diet_climbing".equals(post.getCategory()))
                .collect(Collectors.toList());
        model.addAttribute("posts", posts);
        model.addAttribute("userEmail", userDetails.getUsername());
        return "diet_climbingCrew";
    }

    @GetMapping("/diet_climbing/new")
    public String createDietClimbingCrewPostForm(Model model) {
        model.addAttribute("post", new CrewPost());
        return "diet_climbingCrew_form";
    }

    @PostMapping("/diet_climbing")
    public String createDietClimbingCrewPost(@ModelAttribute CrewPost post, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        post.getCrewMembers().add(user);
        post.setCategory("diet_climbing"); // 종목 설정
        post.setCreatedBy(userDetails.getUsername()); // 작성자 이메일 설정
        crewPostRepository.save(post);
        return "redirect:/crew/diet_climbing";
    }

    @PostMapping("/diet_climbing/join/{id}")
    public String joinDietClimbingCrew(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        CrewPost post = crewPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        if (!post.isClosed() && post.getCrewMembers().size() < post.getMaxMembers() && !post.getCrewMembers().contains(user)) {
            post.getCrewMembers().add(user);
            if (post.getCrewMembers().size() >= post.getMaxMembers()) {
                post.setClosed(true);
            }
            crewPostRepository.save(post);
        }
        return "redirect:/crew/diet_climbing";
    }

    @PostMapping("/diet_climbing/close/{id}")
    public String closeDietClimbingCrew(@PathVariable Long id) {
        CrewPost post = crewPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        post.setClosed(true);
        crewPostRepository.save(post);
        return "redirect:/crew/diet_climbing";
    }
}
