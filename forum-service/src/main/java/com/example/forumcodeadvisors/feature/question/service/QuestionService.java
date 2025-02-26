package com.example.forumcodeadvisors.feature.question.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.feature.question.dto.CreateQuestionRequest;
import com.example.forumcodeadvisors.feature.question.dto.QuestionResponse;
import org.springframework.data.domain.Page;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {

    BaseResponse<?> createQuestion(CreateQuestionRequest createForumRequest, Jwt jwt);

    BaseResponse<?> publishQuestion(String questionUuid, String userUuid);

    BaseResponse<?> deleteQuestion(String questionUuid);

    BaseResponse<?> archiveQuestion(String questionUuid);

    BaseResponse<?> unarchiveQuestion(String questionUuid);

    Page<QuestionResponse> findAllQuestions(int page, int size);

    Page<QuestionResponse> findAllUnArchivedQuestions(int page, int size);

    QuestionResponse findQuestionByUuid(String questionUuid);

    QuestionResponse findQuestionBySlug(String slug);

    Page<QuestionResponse> findAllOwnerQuestions(Jwt jwt, int page, int size);

    Page<QuestionResponse> findAllQuestionsByTagName(String tagName, int page, int size);

    Page<QuestionResponse> findAllQuestionsByAuthurName(String authorName, int page, int size);



}
