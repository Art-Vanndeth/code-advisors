package com.example.forumcodeadvisors.feature.answer.controller;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.answer.dto.*;
import com.example.forumcodeadvisors.feature.answer.service.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<?> createAnswer(@Valid @RequestBody CreateAnswerRequest createAnswerRequest,
                                        @AuthenticationPrincipal Jwt jwt) {
        return answerService.createAnswer(createAnswerRequest, jwt);
    }

    @GetMapping("/{answerUuid}")
    public ParentAnswerResponse findAnswerByUuid(@PathVariable String answerUuid) {
        return answerService.findAnswerByUuid(answerUuid);
    }

    @GetMapping("/{questionSlug}/question")
    public Page<ParentAnswerResponse> findAllAnswerByQuestionSlug(@PathVariable String questionSlug,
                                                                    @RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "10") int size) {
        return answerService.findAllAnswerByQuestionSlug(questionSlug, page, size);
    }

    @DeleteMapping("/{answerUuid}/soft-delete")
    public BaseResponse<?> deleteAnswer(@PathVariable String answerUuid, @AuthenticationPrincipal Jwt jwt) {
        return answerService.deleteAnswer(answerUuid, jwt);
    }

    @PutMapping("/accepted")
    public BaseResponse<?> acceptAnswer(@RequestBody AcceptAnswerRequest acceptAnswerRequest, @AuthenticationPrincipal Jwt jwt) {
        return answerService.acceptAnswer(acceptAnswerRequest, jwt);
    }

    @PutMapping("/un-accepted")
    public BaseResponse<?> unAcceptAnswer(@RequestBody AcceptAnswerRequest acceptAnswerRequest, @AuthenticationPrincipal Jwt jwt) {
        return answerService.unAcceptAnswer(acceptAnswerRequest, jwt);
    }

    @PutMapping
    public BaseResponse<?> updateAnswer(@RequestBody UpdateAnswerRequest updateAnswerRequest, @AuthenticationPrincipal Jwt jwt) {
        return answerService.updateAnswer(updateAnswerRequest, jwt);
    }

    @GetMapping("/{questionSlug}/total")
    public TotalAnswerResponse getTotalAnswerByQuestionSlug(@PathVariable String questionSlug) {
        return answerService.getTotalAnswerByQuestionSlug(questionSlug);
    }

    @GetMapping("/total")
    public TotalAnswerResponse getTotalAnswer() {
        return answerService.getTotalAnswer();
    }
}
