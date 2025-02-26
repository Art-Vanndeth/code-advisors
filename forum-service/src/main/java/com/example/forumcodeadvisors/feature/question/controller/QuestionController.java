package com.example.forumcodeadvisors.feature.question.controller;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.question.dto.CreateQuestionRequest;
import com.example.forumcodeadvisors.feature.question.dto.QuestionResponse;
import com.example.forumcodeadvisors.feature.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/questions")
@RequiredArgsConstructor
@Slf4j
public class QuestionController {

    private final QuestionService questionService;


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/hello")
    Map<String, Object> hello(@AuthenticationPrincipal Jwt jwt) {
        log.info("JWT: {}", jwt.getClaimAsString("userUuid"));
        log.info("JWT TEST");
        //log.info("JWT: {}", jwt);
        return Map.of("message", "Hello, ");
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BaseResponse<?> createQuestion(@Valid @RequestBody CreateQuestionRequest createQuestionRequest, @AuthenticationPrincipal Jwt jwt) {
        return questionService.createQuestion(createQuestionRequest, jwt);
    }

    @PostMapping("/publish")
    public BaseResponse<?> publishQuestion(@RequestParam String questionUuid, @RequestParam String userUuid) {
        return questionService.publishQuestion(questionUuid, userUuid);
    }

    @DeleteMapping("/{questionUuid}/soft-delete")
    public BaseResponse<?> deleteQuestion(@PathVariable String questionUuid) {
        return questionService.deleteQuestion(questionUuid);
    }

    @PostMapping("/{questionUuid}/archive")
    public BaseResponse<?> archiveQuestion(@PathVariable String questionUuid) {
        return questionService.archiveQuestion(questionUuid);
    }

    @PostMapping("/{questionUuid}/unarchive")
    public BaseResponse<?> unarchiveQuestion(@PathVariable String questionUuid) {
        return questionService.unarchiveQuestion(questionUuid);
    }

    @GetMapping
    public Page<QuestionResponse> findAllQuestions( @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {

        return questionService.findAllQuestions(page, size);
    }

    @GetMapping("/archived")
    public Page<QuestionResponse> findAllUnArchivedQuestions(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size) {
        return questionService.findAllUnArchivedQuestions(page, size);
    }

    @GetMapping("/{questionUuid}")
    public QuestionResponse findQuestionByUuid(@PathVariable String questionUuid) {
        return questionService.findQuestionByUuid(questionUuid);
    }

    @GetMapping("/owner")
    public Page<QuestionResponse> findAllOwnerQuestions(@AuthenticationPrincipal Jwt jwt,
                                                        @RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size) {

        log.info("JWT: {}", jwt.getClaimAsString("userUuid"));
        return questionService.findAllOwnerQuestions(jwt, page, size);
    }

    @GetMapping("/slug/{slug}")
    public QuestionResponse findQuestionBySlug(@PathVariable String slug) {
        return questionService.findQuestionBySlug(slug);
    }

    @GetMapping("/tag/{tagName}")
    public Page<QuestionResponse> findAllQuestionsByTagName(@PathVariable String tagName, @RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size) {
        return questionService.findAllQuestionsByTagName(tagName, page, size);
    }

    @GetMapping("/author/{authorName}")
    public Page<QuestionResponse> findAllQuestionsByAuthorName(@PathVariable String authorName,
                                                               @RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "10") int size) {
        return questionService.findAllQuestionsByAuthurName(authorName, page, size);
    }

}
