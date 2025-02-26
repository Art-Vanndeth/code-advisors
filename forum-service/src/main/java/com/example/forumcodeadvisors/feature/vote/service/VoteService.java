package com.example.forumcodeadvisors.feature.vote.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.vote.dto.TotalVoteResponse;
import org.springframework.security.oauth2.jwt.Jwt;

public interface VoteService {


    BaseResponse<?> voteQuestion(String slug, Jwt jwt);

    BaseResponse<?> downVoteQuestion(String slug, Jwt jwt);

    TotalVoteResponse totalQuestionVotesUp(String slug);

    TotalVoteResponse totalQuestionVotesDown(String slug);

    BaseResponse<?> voteAnswer(String answerUuid, String userUuid);

    TotalVoteResponse totalAnswerVotesUp(String answerUuid);

    TotalVoteResponse totalAnswerVotesDown(String answerUuid);

    BaseResponse<?> downVoteAnswer(String answerUuid, String userUuid);

    BaseResponse<?> checkUserIsVotedOnQuestion(String slug, Jwt jwt);

    BaseResponse<?> checkUserIsVotedOnAnswer(String answerUuid, String userUuid);
}
