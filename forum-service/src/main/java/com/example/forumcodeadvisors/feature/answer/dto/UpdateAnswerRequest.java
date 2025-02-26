package com.example.forumcodeadvisors.feature.answer.dto;

public record UpdateAnswerRequest(
        String answerUuid,
        String content
) {
}
