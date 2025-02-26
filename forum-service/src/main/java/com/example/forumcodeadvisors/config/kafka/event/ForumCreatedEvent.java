package com.example.forumcodeadvisors.config.kafka.event;

import com.example.forumcodeadvisors.feature.tag.dto.TagResponse;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForumCreatedEvent {
    private String uuid;
    private String slug;
    private String authorUuid;
    private String title;
    private String description;
    private String introduction;
    private String expectedAnswers;
}
