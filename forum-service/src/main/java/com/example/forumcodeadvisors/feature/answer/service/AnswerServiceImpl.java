package com.example.forumcodeadvisors.feature.answer.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.config.kafka.event.ForumAnswerCreatedEvent;
import com.example.forumcodeadvisors.domain.Answer;
import com.example.forumcodeadvisors.domain.Question;
import com.example.forumcodeadvisors.feature.answer.dto.*;
import com.example.forumcodeadvisors.feature.answer.mapper.AnswerMapper;
import com.example.forumcodeadvisors.feature.answer.repository.AnswerRepository;
import com.example.forumcodeadvisors.feature.question.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final AnswerMapper answerMapper;
    private final KafkaTemplate<String, Object> kafkaTemplate;



    /**
     * Create an answer or reply
     *
     * @param createAnswerRequest
     * @return BaseResponse<?>
     * by Yith Sopheaktra
     */
    @Transactional
    @Override
    public BaseResponse<?> createAnswer(CreateAnswerRequest createAnswerRequest, Jwt jwt) {

        String userUuid = jwt.getClaim("userUuid");
        String userName = jwt.getClaim("username");

        // check if user is null
        if (userUuid == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Author UUID is required"
            );
        }

        Question question = questionRepository.findBySlugAndIsArchivedAndIsDeletedAndIsDrafted(createAnswerRequest.questionSlug(), false, false, false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Question not found"
                ));


        Answer parentAnswer;

        // check if answerUuid is null ( This mean this is the first answer )
        if (createAnswerRequest.answerUuid() == null) {
            parentAnswer = answerMapper.fromCreateAnswerRequest(createAnswerRequest);
            parentAnswer.setUuid(UUID.randomUUID().toString());
            parentAnswer.setQuestion(question);
            parentAnswer.setReplies(List.of());
            parentAnswer.setIsParent(true);
            parentAnswer.setAuthorUuid(userUuid);
            parentAnswer.setAuthorUsername(userName);
            answerRepository.save(parentAnswer);

            if(!userUuid.equals(question.getAuthorUuid())){
                kafkaTemplate.send("forum-answer-created-events-topic", parentAnswer.getUuid(), ForumAnswerCreatedEvent.builder()
                        .answerOwnerUuid(parentAnswer.getAuthorUuid())
                        .questionOwnerUuid(question.getAuthorUuid())
                        .forumSlug(question.getSlug())
                        .description(parentAnswer.getContent())
                        .build());
            }

        } else { // if answerUuid is not null ( This mean this is a reply )
            // get the parent answer
            parentAnswer = answerRepository.findByUuidAndIsDeleted(createAnswerRequest.answerUuid(), false)
                    .orElseThrow(()-> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Parent answer not found"
                    ));

            // map the request to answer
            Answer answer = answerMapper.fromCreateAnswerRequest(createAnswerRequest);
            answer.setUuid(UUID.randomUUID().toString());
            answer.setQuestion(question);
            answer.setIsParent(false);
            answer.setReplies(List.of());
            answer.setAuthorUsername(userName);
            answer.setAuthorUuid(userUuid);

            // get the replies of the parent answer
            List<Answer> answerList = parentAnswer.getReplies();

            // add the new reply to the list
            answerList.add(answer);
            // set the replies to the parent answer
            parentAnswer.setReplies(answerList);
            answerRepository.save(parentAnswer);
            if(!parentAnswer.getAuthorUuid().equals(userUuid)){
                kafkaTemplate.send("forum-reply-created-events-topic", parentAnswer.getUuid(), ForumAnswerCreatedEvent.builder()
                        .answerOwnerUuid(parentAnswer.getAuthorUuid())
                        .questionOwnerUuid(question.getAuthorUuid())
                        .forumSlug(question.getSlug())
                        .description(answer.getContent())
                        .build());
            }

        }

        return BaseResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Answer or Reply created successfully")
                .build();
    }


    /**
     * Find answer by UUID
     *
     * @param answerUuid
     * @return ParentAnswerResponse
     * by Yith Sopheaktra
     */
    @Override
    public ParentAnswerResponse findAnswerByUuid(String answerUuid) {

        Answer answer = answerRepository.findByUuid(answerUuid)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Answer not found"
                ));

        return answerMapper.toParentAnswerResponse(answer);
    }


    /**
     * Find all answers
     *
     * @return List<ParentAnswerResponse>
     * by Yith Sopheaktra
     */
    @Override
    public Page<ParentAnswerResponse> findAllAnswerByQuestionSlug(String questionSlug, int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(
                Sort.Order.desc("isAccepted"),  // Accepted answers first
                Sort.Order.desc("createdAt")    // Then by creation date (newest first)
        ));

        Page<Answer> answers = answerRepository.findAllByQuestionAndIsDeletedAndIsParent(
                questionRepository.findBySlugAndIsArchivedAndIsDeletedAndIsDrafted(questionSlug, false,false,false).orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Question not found"
                )),
                false,
                pageable,
                true
        );
        return answers.map(answerMapper::toParentAnswerResponse);
    }

    /**
     * Delete an answer
     *
     * @param answerUuid
     * @param jwt (userJwt)
     * @return BaseResponse<?>
     * by Yith Sopheaktra
     * @problem The author of the question should be able to delete the answer of the question and also the author of the answer should be able to delete the answer
     */
    @Override
    public BaseResponse<?> deleteAnswer(String answerUuid, Jwt jwt) {

        String authorUuid = jwt.getClaim("userUuid");

        Answer answer = answerRepository.findByUuidAndIsDeleted(answerUuid, false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Answer not found"
                ));

        if(!answer.getAuthorUuid().equals(authorUuid)){
            if(!answer.getQuestion().getAuthorUuid().equals(authorUuid)){
                throw new ResponseStatusException(
                        HttpStatus.FORBIDDEN,
                        "You are not allowed to delete this answer"
                );
            }
        }

        answer.setIsDeleted(true);
        answerRepository.save(answer);

        return BaseResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Answer deleted successfully")
                .build();
    }

    /**
     * Accept an answer
     *
     * @param acceptAnswerRequest
     * @return BaseResponse<?>
     * by Yith Sopheaktra
     */
    @Override
    public BaseResponse<?> acceptAnswer(AcceptAnswerRequest acceptAnswerRequest, Jwt jwt) {

        String authorUuid = jwt.getClaim("userUuid");

        Answer answer = answerRepository.findByUuidAndIsDeleted(acceptAnswerRequest.answerUuid(), false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Answer not found"
                ));

        Question question = answer.getQuestion();

        // check if the author of the question is the same as the author of the answer
        if(!question.getAuthorUuid().equals(authorUuid)){
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "You are not allowed to accept this answer"
            );
        }

        // check if the answer is already accepted
        if(answer.getIsAccepted()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Answer is already accepted"
            );
        }

        answer.setIsAccepted(true);
        answerRepository.save(answer);

        return BaseResponse.builder()
                .code(HttpStatus.OK.value())
                .message("Answer accepted successfully")
                .build();
    }

    @Override
    public BaseResponse<?> unAcceptAnswer(AcceptAnswerRequest acceptAnswerRequest, Jwt jwt) {

        String authorUuid = jwt.getClaim("userUuid");

        Answer answer = answerRepository.findByUuidAndIsDeleted(acceptAnswerRequest.answerUuid(), false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Answer not found"
                ));

        Question question = answer.getQuestion();

        // check if the author of the question is the same as the author of the answer
        if(!question.getAuthorUuid().equals(authorUuid)){
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "You are not allowed to accept this answer"
            );
        }

        // check if the answer is already unaccepted
        if(!answer.getIsAccepted()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Answer is already accepted"
            );
        }

        answer.setIsAccepted(false);
        answerRepository.save(answer);

        return BaseResponse.builder()
                .code(HttpStatus.OK.value())
                .message("Answer accepted successfully")
                .build();
    }

    @Override
    public BaseResponse<?> updateAnswer(UpdateAnswerRequest updateAnswerRequest, Jwt jwt) {

        String authorUuid = jwt.getClaim("userUuid");

        Answer answer = answerRepository.findByUuidAndIsDeleted(updateAnswerRequest.answerUuid(), false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Answer not found"
                ));

        if(!answer.getAuthorUuid().equals(authorUuid)){
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "You are not allowed to update this answer"
            );
        }

        answer.setContent(updateAnswerRequest.content());
        answerRepository.save(answer);

        return BaseResponse.builder()
                .code(HttpStatus.OK.value())
                .message("Answer updated successfully")
                .build();

    }

    @Override
    public TotalAnswerResponse getTotalAnswerByQuestionSlug(String questionSlug) {

        Long totalAnswer = answerRepository.countByQuestionSlugAndIsDeleted(questionSlug, false);

        return new TotalAnswerResponse(totalAnswer);
    }

    @Override
    public TotalAnswerResponse getTotalAnswer() {
        Long totalAnswer = answerRepository.count();
        return new TotalAnswerResponse(totalAnswer);
    }

}
