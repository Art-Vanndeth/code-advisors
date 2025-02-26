package com.example.forumcodeadvisors.feature.answer.dto;

public record AcceptAnswerRequest(
        String questionSlug,
        String answerUuid
) {
}
