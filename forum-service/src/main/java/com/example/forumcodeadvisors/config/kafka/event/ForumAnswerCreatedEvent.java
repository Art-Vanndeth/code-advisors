package com.example.forumcodeadvisors.config.kafka.event;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForumAnswerCreatedEvent {
    private String questionOwnerUuid;
    private String answerOwnerUuid;
    private String description;
    private String forumSlug;
}
