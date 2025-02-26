package com.example.forumcodeadvisors.domain;

import com.example.forumcodeadvisors.audit.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "question")
@Setter
@Getter
@NoArgsConstructor
public class Question extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    private String title;

    private String slug;

    @Column(columnDefinition = "TEXT")
    private String introduction; // introduces the question

    @Column(columnDefinition = "TEXT")
    private String expectedAnswers; // concludes the question

    @Column(columnDefinition = "TEXT")
    private String description; // describes the question

    private String authorUuid;

    private String authorUsername;

    private Boolean isArchived = false;

    private Boolean isDeleted = false;

    private Boolean isDrafted = false;

    @OneToMany(mappedBy = "question")
    private List<Vote> vote;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "question_tag",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;


}
