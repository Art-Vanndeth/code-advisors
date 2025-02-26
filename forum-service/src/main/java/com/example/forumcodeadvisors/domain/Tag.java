package com.example.forumcodeadvisors.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tags")
@Setter
@Getter
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slug;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Boolean isDeleted = false;

    @ManyToMany(mappedBy = "tags",fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Question> questions;


}
