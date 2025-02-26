package com.example.forumcodeadvisors.feature.answer.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.answer.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public interface AnswerService {

    BaseResponse<?> createAnswer(CreateAnswerRequest createAnswerRequest, Jwt jwt);

    ParentAnswerResponse findAnswerByUuid(String answerUuid);

    Page<ParentAnswerResponse> findAllAnswerByQuestionSlug(String questionSlug, int page, int size);

    BaseResponse<?> deleteAnswer(String answerUuid, Jwt jwt);

    BaseResponse<?> acceptAnswer(AcceptAnswerRequest acceptAnswerRequest, Jwt jwt);

    BaseResponse<?> unAcceptAnswer(AcceptAnswerRequest acceptAnswerRequest, Jwt jwt);

    BaseResponse<?> updateAnswer(UpdateAnswerRequest updateAnswerRequest, Jwt jwt);

    TotalAnswerResponse getTotalAnswerByQuestionSlug(String questionSlug);

    TotalAnswerResponse getTotalAnswer();

}
