package com.example.forumcodeadvisors.feature.vote.controller;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.vote.dto.TotalVoteResponse;
import com.example.forumcodeadvisors.feature.vote.service.VoteService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@Setter
@Getter
@RequestMapping("/api/v1/votes")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/question/up-vote")
    public BaseResponse<?> voteQuestion(@RequestParam String slug,
                                        @AuthenticationPrincipal Jwt jwt) {
        return voteService.voteQuestion(slug, jwt);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/question/down-vote")
    public BaseResponse<?> downVoteQuestion(@RequestParam String slug,
                                            @AuthenticationPrincipal Jwt jwt) {
        return voteService.downVoteQuestion(slug, jwt);
    }

    @GetMapping("question/{slug}/total-up-votes")
    public TotalVoteResponse totalQuestionUpVotes(@PathVariable String slug) {
        return voteService.totalQuestionVotesUp(slug);
    }

    @GetMapping("question/{slug}/total-down-votes")
    public TotalVoteResponse totalQuestionDownVotes(@PathVariable String slug) {
        return voteService.totalQuestionVotesDown(slug);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/question/check-vote")
    public BaseResponse<?> checkUserIsVotedOnQuestion(@RequestParam String slug,
                                                      @AuthenticationPrincipal Jwt jwt) {
        return voteService.checkUserIsVotedOnQuestion(slug, jwt);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/answers")
    public BaseResponse<?> voteAnswer(@RequestParam String answerUuid,
                                      @AuthenticationPrincipal Jwt jwt) {
        String userUuid = jwt.getClaimAsString("userUuid");
        return voteService.voteAnswer(answerUuid, userUuid);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/answers/down-vote")
    public BaseResponse<?> downVoteAnswer(@RequestParam String answerUuid,
                                          @AuthenticationPrincipal Jwt jwt) {
        String userUuid = jwt.getClaimAsString("userUuid");
        return voteService.downVoteAnswer(answerUuid, userUuid);
    }

    @GetMapping("answers/{answerUuid}/total-up-votes")
    public TotalVoteResponse totalAnswerVotesUp(@PathVariable String answerUuid) {
        return voteService.totalAnswerVotesUp(answerUuid);
    }

    @GetMapping("answers/{answerUuid}/total-down-votes")
    public TotalVoteResponse totalAnswerVotesDown(@PathVariable String answerUuid) {
        return voteService.totalAnswerVotesDown(answerUuid);
    }

    @GetMapping("/answers/check-vote")
    public BaseResponse<?> checkUserIsVotedOnAnswer(@RequestParam String answerUuid,
                                                   @AuthenticationPrincipal Jwt jwt) {
        String userUuid = jwt.getClaimAsString("userUuid");
        return voteService.checkUserIsVotedOnAnswer(answerUuid, userUuid);
    }
}
