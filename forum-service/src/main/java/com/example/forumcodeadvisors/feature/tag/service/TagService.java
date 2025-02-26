package com.example.forumcodeadvisors.feature.tag.service;

import com.example.forumcodeadvisors.domain.Tag;
import com.example.forumcodeadvisors.feature.tag.dto.TagResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {

    List<TagResponse> findAllTags();

    List<TagResponse> findTagsByQuestionUuid(String questionUuid);

}
