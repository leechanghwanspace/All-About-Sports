package com.allaboutsports.AaS.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class MatchingPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private String location;
    private String gender;
    private int maxMembers;
    private boolean isClosed = false;
    private String createdBy; // 매칭 공고를 작성한 유저의 이메일
    private String category;  // 매칭 공고의 카테고리

    @ManyToMany
    @JoinTable(
            name = "matching_members",
            joinColumns = @JoinColumn(name = "matching_post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> matchingMembers = new HashSet<>();

    // category 필드의 getter와 setter 추가
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
