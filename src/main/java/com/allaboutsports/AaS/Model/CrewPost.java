package com.allaboutsports.AaS.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class CrewPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int maxMembers; // 최대 모집 인원 수
    private boolean isClosed = false; // 모집 상태
    private String category; // 종목 필드 추가
    private String createdBy; // 크루원 모집 글을 작성한 사람의 이메일 추가

    @ManyToMany
    @JoinTable(
            name = "crew_members",
            joinColumns = @JoinColumn(name = "crew_post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> crewMembers = new HashSet<>(); // 중복 제거를 위한 Set 사용

    // createdBy 필드의 getter와 setter 추가
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
