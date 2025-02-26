package com.example.forumcodeadvisors.feature.tag.service;

import com.example.forumcodeadvisors.domain.Question;
import com.example.forumcodeadvisors.domain.Tag;
import com.example.forumcodeadvisors.feature.question.repository.QuestionRepository;
import com.example.forumcodeadvisors.feature.tag.dto.TagResponse;
import com.example.forumcodeadvisors.feature.tag.mapper.TagMapper;
import com.example.forumcodeadvisors.feature.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService{

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;
    private final QuestionRepository questionRepository;

    @Override
    public List<TagResponse> findAllTags() {

        List<Tag> tags = tagRepository.findAll();

        return tagMapper.toTagResponse(tags);
    }

    @Override
    public List<TagResponse> findTagsByQuestionUuid(String questionUuid) {

        Question question = questionRepository.findByUuid(questionUuid)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        List<Tag> tags = question.getTags();

        return tagMapper.toTagResponse(tags);

    }


}
