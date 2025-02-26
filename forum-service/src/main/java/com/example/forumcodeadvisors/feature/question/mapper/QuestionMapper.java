package com.example.forumcodeadvisors.feature.question.mapper;

import com.example.forumcodeadvisors.domain.Question;
import com.example.forumcodeadvisors.domain.Tag;
import com.example.forumcodeadvisors.domain.Vote;
import com.example.forumcodeadvisors.feature.question.dto.CreateQuestionRequest;
import com.example.forumcodeadvisors.feature.question.dto.QuestionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionResponse toQuestionResponse(Question question);

    List<QuestionResponse> toQuestionResponse(List<Question> questions);

    @Mapping(source = "tagName", target = "tags", qualifiedByName = "mapTagNames")
    Question fromCreateQuestionRequest(CreateQuestionRequest createForumRequest);

    @Named("mapTagNames")
    default List<Tag> mapTagNames(List<String> tagNames) {
        return tagNames.stream()
                .map(this::mapTagName)
                .collect(Collectors.toList());
    }

    default Tag mapTagName(String name) {
        Tag tag = new Tag();
        tag.setName(name);
        return tag;
    }

}
