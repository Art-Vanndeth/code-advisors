package com.example.forumcodeadvisors.feature.vote.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.domain.Answer;
import com.example.forumcodeadvisors.domain.Question;
import com.example.forumcodeadvisors.domain.Vote;
import com.example.forumcodeadvisors.feature.answer.repository.AnswerRepository;
import com.example.forumcodeadvisors.feature.question.repository.QuestionRepository;
import com.example.forumcodeadvisors.feature.vote.dto.TotalVoteResponse;
import com.example.forumcodeadvisors.feature.vote.repository.VoteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
public class    VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    /**
     * Vote for a question
     *
     * @param slug
     * @param jwt
     * @return BaseResponse<?>
     */
    @Transactional
    @Override
    public BaseResponse<?> voteQuestion(String slug, Jwt jwt) {

        String userUuid = jwt.getClaimAsString("userUuid");

        // check if user is null
        if (userUuid == null) {
            throw new ResponseStatusException(
                    BAD_REQUEST,
                    "User UUID is required"
            );
        }

        Question question = questionRepository.findBySlugAndIsArchivedAndIsDeletedAndIsDrafted(slug, false, false, false)
                .orElseThrow(() -> new ResponseStatusException(
                        BAD_REQUEST,
                        "Question not found"
                ));

        List<Vote> votes = question.getVote();

        // check if user has already voted
        for (Vote vote : votes) {
            if (vote.getUserUuid().equals(userUuid)) {
                if (vote.getIsUpvote()) {
                    throw new ResponseStatusException(
                            CONFLICT,
                            "User has already voted"
                    );
                } else {
                    vote.setIsUpvote(true);
                    voteRepository.save(vote);
                    return BaseResponse
                            .builder()
                            .code(HttpStatus.OK.value())
                            .message("Vote successful")
                            .build();
                }
            }
        }

        Vote vote = new Vote();
        vote.setQuestion(question);
        vote.setUserUuid(userUuid);
        vote.setUuid(UUID.randomUUID().toString());
        vote.setIsUpvote(true);
        voteRepository.save(vote);

        return BaseResponse
                .builder()
                .code(HttpStatus.OK.value())
                .message("Vote successful")
                .build();
    }

    /**
     * Get total votes for a question
     *
     * @param slug
     * @return TotalVoteResponse
     */
    @Override
    public TotalVoteResponse totalQuestionVotesUp(String slug) {

        Question question = questionRepository.findBySlugAndIsArchivedAndIsDeletedAndIsDrafted(slug, false, false, false)
                .orElseThrow(() -> new ResponseStatusException(
                        BAD_REQUEST,
                        "Question not found"
                ));

        List<Vote> upVote = voteRepository.findByQuestionAndIsUpvote(question, true);

        return TotalVoteResponse
                .builder()
                .totalVotes(upVote.size())
                .build();
    }

    @Override
    public TotalVoteResponse totalQuestionVotesDown(String slug) {

        Question question = questionRepository.findBySlugAndIsArchivedAndIsDeletedAndIsDrafted(slug, false, false, false)
                .orElseThrow(() -> new ResponseStatusException(
                        BAD_REQUEST,
                        "Question not found"
                ));

        List<Vote> downVote = voteRepository.findByQuestionAndIsUpvote(question, false);

        return TotalVoteResponse
                .builder()
                .totalVotes(downVote.size())
                .build();

    }

    /**
     * Downvote a question
     *
     * @param slug
     * @param jwt
     * @return BaseResponse<?>
     */
    @Override
    public BaseResponse<?> downVoteQuestion(String slug, Jwt jwt) {

        String userUuid = jwt.getClaimAsString("userUuid");

        Question question = questionRepository.findBySlugAndIsArchivedAndIsDeletedAndIsDrafted(slug, false, false, false)
                .orElseThrow(() -> new ResponseStatusException(
                        BAD_REQUEST,
                        "Question not found"
                ));

        List<Vote> votes = question.getVote();
        votes.forEach(vote -> {
            if (vote.getUserUuid().equals(userUuid)) {
                if (vote.getIsUpvote()) {
                    vote.setIsUpvote(false);
                    voteRepository.save(vote);
                } else {
                    throw new ResponseStatusException(
                            BAD_REQUEST,
                            "User has not voted"
                    );
                }
            }
        });

        return BaseResponse
                .builder()
                .code(HttpStatus.OK.value())
                .message("Downvote successful")
                .build();

    }

    /**
     * Check if user has voted on a question
     *
     * @param slug
     * @param jwt
     * @return BaseResponse<?>
     */
    @Override
    public BaseResponse<?> checkUserIsVotedOnQuestion(String slug, Jwt jwt) {

        String userUuid = jwt.getClaimAsString("userUuid");

        Question question = questionRepository.findBySlugAndIsArchivedAndIsDeletedAndIsDrafted(slug, false, false, false)
                .orElseThrow(() -> new ResponseStatusException(
                        BAD_REQUEST,
                        "Question not found"
                ));


        List<Vote> votes = question.getVote();

        for (Vote vote : votes) {
            if (vote.getUserUuid().equals(userUuid)) {
                if (!vote.getIsUpvote()) {
                    return BaseResponse
                            .builder()
                            .code(CONFLICT.value())
                            .message("isVoted : " + false)
                            .build();
                } else {
                    return BaseResponse
                            .builder()
                            .code(HttpStatus.OK.value())
                            .message("isVoted : " + true)
                            .build();
                }
            }
        }

        return BaseResponse
                .builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message("User has not voted")
                .build();

    }

    /**
     * Check if user has voted on an answer
     *
     * @param answerUuid
     * @param userUuid
     * @return BaseResponse<?>
     */
    @Override
    public BaseResponse<?> checkUserIsVotedOnAnswer(String answerUuid, String userUuid) {

            Answer answer = answerRepository.findByUuidAndIsDeleted(answerUuid, false)
                    .orElseThrow(() -> new ResponseStatusException(
                            BAD_REQUEST,
                            "Answer not found"
                    ));

            List<Vote> votes = answer.getVote();

            for (Vote vote : votes) {
                if (vote.getUserUuid().equals(userUuid)) {
                    if (!vote.getIsUpvote()) {
                        return BaseResponse
                                .builder()
                                .code(CONFLICT.value())
                                .message("isVoted : " + false)
                                .build();
                    } else {
                        return BaseResponse
                                .builder()
                                .code(HttpStatus.OK.value())
                                .message("isVoted : " + true)
                                .build();
                    }
                }
            }

            return BaseResponse
                    .builder()
                    .code(HttpStatus.NOT_FOUND.value())
                    .message("User has not voted")
                    .build();
    }

    /**
     * Vote for an answer
     *
     * @param answerUuid
     * @param userUuid
     * @return BaseResponse<?>
     */
    @Override
    public BaseResponse<?> voteAnswer(String answerUuid, String userUuid) {

        // check if user is null
        if (userUuid == null) {
            throw new ResponseStatusException(
                    BAD_REQUEST,
                    "User UUID is required"
            );
        }

        // check if answer is null
        Answer answer = answerRepository.findByUuidAndIsDeleted(answerUuid, false)
                .orElseThrow(() -> new ResponseStatusException(
                        BAD_REQUEST,
                        "Answer not found"
                ));

        List<Vote> votes = answer.getVote();

        // check if user has already voted
        for (Vote vote : votes) {
            if (vote.getUserUuid().equals(userUuid)) {
                if (vote.getIsUpvote()) {
                    throw new ResponseStatusException(
                            CONFLICT,
                            "User has already voted"
                    );
                } else {
                    vote.setIsUpvote(true);
                    voteRepository.save(vote);
                    return BaseResponse
                            .builder()
                            .code(HttpStatus.OK.value())
                            .message("Vote successful")
                            .build();
                }
            }
        }

        Vote vote = new Vote();
        vote.setQuestion(answer.getQuestion());
        vote.setAnswer(answer);
        vote.setUserUuid(userUuid);
        vote.setUuid(UUID.randomUUID().toString());
        vote.setIsUpvote(true);
        voteRepository.save(vote);

        return BaseResponse
                .builder()
                .code(HttpStatus.OK.value())
                .message("Vote successful")
                .build();
    }

    /**
     * Get total votes for an answer
     *
     * @param answerUuid
     * @return TotalVoteResponse
     */
    @Override
    public TotalVoteResponse totalAnswerVotesUp(String answerUuid) {
        Answer answer = answerRepository.findByUuidAndIsDeleted(answerUuid, false)
                .orElseThrow(() -> new ResponseStatusException(
                        BAD_REQUEST,
                        "Answer not found"
                ));

        List<Vote> upVote = voteRepository.findByAnswerAndIsUpvote(answer, true);

        return TotalVoteResponse
                .builder()
                .totalVotes(upVote.size())
                .build();
    }

    @Override
    public TotalVoteResponse totalAnswerVotesDown(String answerUuid) {
        Answer answer = answerRepository.findByUuidAndIsDeleted(answerUuid, false)
                .orElseThrow(() -> new ResponseStatusException(
                        BAD_REQUEST,
                        "Answer not found"
                ));

        List<Vote> downVote = voteRepository.findByAnswerAndIsUpvote(answer, false);

        return TotalVoteResponse
                .builder()
                .totalVotes(downVote.size())
                .build();
    }

    /**
     * Downvote an answer
     *
     * @param answerUuid
     * @param userUuid
     * @return BaseResponse<?>
     */
    @Override
    public BaseResponse<?> downVoteAnswer(String answerUuid, String userUuid) {

        Answer answer = answerRepository.findByUuidAndIsDeleted(answerUuid, false)
                .orElseThrow(() -> new ResponseStatusException(
                        BAD_REQUEST,
                        "Answer not found"
                ));

        List<Vote> votes = answer.getVote();
        votes.forEach(vote -> {
            if (vote.getUserUuid().equals(userUuid)) {
                if (vote.getIsUpvote()) {
                    vote.setIsUpvote(false);
                    voteRepository.save(vote);
                } else {
                    throw new ResponseStatusException(
                            BAD_REQUEST,
                            "User has not voted"
                    );
                }
            }

        });

        return BaseResponse
                .builder()
                .code(HttpStatus.OK.value())
                .message("Downvote successful")
                .build();

    }





}
