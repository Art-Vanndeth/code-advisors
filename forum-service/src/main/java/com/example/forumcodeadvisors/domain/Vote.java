package com.example.forumcodeadvisors.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "votes")
@NoArgsConstructor
@Setter
@Getter
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    private Boolean isUpvote;

    private Boolean isDeleted = false;

    private String userUuid;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Answer answer;
}
