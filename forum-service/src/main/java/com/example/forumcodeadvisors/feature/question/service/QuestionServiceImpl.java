package com.example.forumcodeadvisors.feature.question.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.config.kafka.event.ForumAnswerCreatedEvent;
import com.example.forumcodeadvisors.config.kafka.event.ForumCreatedEvent;
import com.example.forumcodeadvisors.domain.Question;
import com.example.forumcodeadvisors.domain.Tag;
import com.example.forumcodeadvisors.feature.question.dto.CreateQuestionRequest;
import com.example.forumcodeadvisors.feature.question.dto.QuestionResponse;
import com.example.forumcodeadvisors.feature.question.mapper.QuestionMapper;
import com.example.forumcodeadvisors.feature.question.repository.QuestionRepository;
import com.example.forumcodeadvisors.feature.tag.repository.TagRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;


@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper questionMapper;
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;



    /**
     * Create forum content
     *
     * @param createQuestionRequest
     * @return BaseResponse
     * by Yith Sopheaktra
     */
    @Transactional
    @Override
    public BaseResponse<?> createQuestion(CreateQuestionRequest createQuestionRequest, Jwt jwt) {

        String userUuid = jwt.getClaim("userUuid");
        String userName = jwt.getClaim("username");

        // check if user is null
        if (userUuid == null) {
            throw new ResponseStatusException(
                    BAD_REQUEST,
                    "Author UUID is required"
            );
        }

        // check if slug is exist
        if(questionRepository.existsBySlug(createQuestionRequest.slug())){
            throw new ResponseStatusException(
                    CONFLICT,
                    "Slug is already exist"
            );
        }

        List<String> tags = createQuestionRequest.tagName();
        // find tags by tag name
        List<Tag> existingTags = tagRepository.findByNameIn(tags);

        // map request to question object
        Question question = questionMapper.fromCreateQuestionRequest(createQuestionRequest);

        // set tags to question
        question.setTags(existingTags);

        // set UUID to question
        question.setAuthorUuid(userUuid);
        question.setUuid(UUID.randomUUID().toString());
        question.setVote(List.of());
        question.setAuthorUsername(userName);

        questionRepository.save(question);

        kafkaTemplate.send("forum-created-events-topic", question.getUuid(), ForumCreatedEvent.builder()
                        .title(question.getTitle())
                        .uuid(question.getUuid())
                        .expectedAnswers(question.getExpectedAnswers())
                        .introduction(question.getIntroduction())
                        .description(question.getDescription())
                        .authorUuid(question.getAuthorUuid())
                        .slug(question.getSlug())
                .build());


        return BaseResponse.builder()
                .code(HttpStatus.CREATED.value())
                .message("Question created successfully")
                .build();

    }


    /**
     * Publish question
     *
     * @param questionUuid
     * @return BaseResponse
     * by Yith Sopheaktra
     */
    @Override
    public BaseResponse<?> publishQuestion(String questionUuid, String userUuid) {

        // find question by UUID
        Question question = questionRepository.findByUuid(questionUuid)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Question not found"));

        // check if user is qualified to publish question
        if(!question.getAuthorUuid().equals(userUuid)){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "You are not qualified to publish this question");
        }

        // check if question is archived
        if(question.getIsArchived()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Question is archived");
        }

        // check if question is deleted
        if(question.getIsDeleted()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Question not found");
        }

        // check if question is already published
        if(!question.getIsDrafted()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Question is already published");
        }

        question.setIsDrafted(false);
        questionRepository.save(question);

        return BaseResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Question published successfully")
                .build();
    }


    /**
     * Delete question
     *
     * @param questionUuid
     * @return BaseResponse
     * by Yith Sopheaktra
     */
    @Override
    public BaseResponse<?> deleteQuestion(String questionUuid) {

        Question question = questionRepository.findByUuidAndIsArchivedAndIsDeletedAndIsDrafted(questionUuid,false,false, false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Question not found"));
        question.setIsDeleted(true);
        questionRepository.save(question);

        return BaseResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Question deleted successfully")
                .build();
    }



    /**
     * Archive question
     *
     * @param questionUuid
     * @return BaseResponse
     * by Yith Sopheaktra
     */
    @Override
    public BaseResponse<?> archiveQuestion(String questionUuid) {

        Question question = questionRepository.findByUuidAndIsArchivedAndIsDeletedAndIsDrafted(questionUuid,false,false, false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Question not found"));
        question.setIsArchived(true);
        questionRepository.save(question);

        return BaseResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Question archived successfully")
                .build();
    }

    @Override
    public BaseResponse<?> unarchiveQuestion(String questionUuid) {

        Question question = questionRepository.findByUuidAndIsArchivedAndIsDeletedAndIsDrafted(questionUuid,true,false, false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Question not found"));
        question.setIsArchived(false);
        questionRepository.save(question);

        return BaseResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Question unarchived successfully")
                .build();
    }


    /**
     * Find all questions
     *
     * @return List<QuestionResponse>
     * by Yith Sopheaktra
     */
    @Override
    public Page<QuestionResponse> findAllQuestions(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Question> questions = questionRepository.findAllByIsArchivedAndIsDeletedAndIsDrafted(false, false, false, pageable);

        return questions.map(questionMapper::toQuestionResponse);
    }

    @Override
    public Page<QuestionResponse> findAllUnArchivedQuestions(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Question> questions = questionRepository.findAllByIsArchivedAndIsDeletedAndIsDrafted(true, false, false, pageable);

        return questions.map(questionMapper::toQuestionResponse);
    }


    /**
     * Find question by UUID
     *
     * @param questionUuid
     * @return QuestionResponse
     * by Yith Sopheaktra
     */
    @Override
    public QuestionResponse findQuestionByUuid(String questionUuid) {
        Question question = questionRepository.findByUuidAndIsArchivedAndIsDeletedAndIsDrafted(questionUuid, false, false, false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Question not found"));

        return questionMapper.toQuestionResponse(question);
    }

    @Override
    public QuestionResponse findQuestionBySlug(String slug) {

        Question question = questionRepository.findBySlugAndIsArchivedAndIsDeletedAndIsDrafted(slug, false, false, false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Question not found"));

        return questionMapper.toQuestionResponse(question);
    }

    @Override
    public Page<QuestionResponse> findAllOwnerQuestions(Jwt jwt, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        // get user UUID from JWT
        String userUuid = jwt.getClaim("userUuid");

        Page<Question> questions = questionRepository.findAllByAuthorUuidAndIsDeletedAndIsDrafted(userUuid, false, false, pageable);

        return questions.map(questionMapper::toQuestionResponse);
    }

    @Override
    public Page<QuestionResponse> findAllQuestionsByTagName(String tagName, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Tag tag = tagRepository.findByName(tagName)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tag not found"));

        Page<Question> questions = questionRepository.findAllByTagsAndIsArchivedAndIsDeletedAndIsDrafted(List.of(tag), false, false, false, pageable);

        return questions.map(questionMapper::toQuestionResponse);

    }

    @Override
    public Page<QuestionResponse> findAllQuestionsByAuthurName(String authorName, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Question> questions = questionRepository.findAllByAuthorUsernameAndIsArchivedAndIsDeletedAndIsDrafted(authorName,false, false, false, pageable);


        return questions.map(questionMapper::toQuestionResponse);
    }
}
