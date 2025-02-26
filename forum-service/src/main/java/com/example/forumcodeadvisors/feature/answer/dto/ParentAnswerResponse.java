package com.example.forumcodeadvisors.feature.answer.dto;

import java.util.List;

public record ParentAnswerResponse(
        String uuid,
        String authorUuid,
        String authorUsername,
        String questionSlug,
        String slug,
        Boolean isParent,
        Boolean isAccepted,
        String content,
        String createdAt,
        String lastModifiedAt,
        List<AnswerResponse> replies
) {
}
