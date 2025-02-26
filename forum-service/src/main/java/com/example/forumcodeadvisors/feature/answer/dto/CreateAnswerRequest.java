package com.example.forumcodeadvisors.feature.answer.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateAnswerRequest(

        @NotBlank
        String questionSlug,

        String answerUuid,

        @NotBlank
        String slug,

        @NotBlank
        String content
) {
}
