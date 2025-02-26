package com.example.forumcodeadvisors.domain;

import com.example.forumcodeadvisors.audit.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "answer")
@Setter
@Getter
@NoArgsConstructor
public class Answer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    private String slug;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String authorUuid;

    private String authorUsername;

    private Boolean isAccepted = false;

    private Boolean isDeleted = false;

    private Boolean isDrafted = false;

    private Boolean isParent = true;

    @OneToMany(mappedBy = "answer")
    private List<Vote> vote;

    @ManyToOne
    private Question question;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> replies;

}
