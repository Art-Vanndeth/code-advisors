package com.example.forumcodeadvisors.feature.tag.controller;

import com.example.forumcodeadvisors.feature.tag.dto.TagResponse;
import com.example.forumcodeadvisors.feature.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tags")
public class tagController {

    private final TagService tagService;

    @GetMapping
    public List<TagResponse> findAllTags() {
        return tagService.findAllTags();
    }

    @GetMapping("/question/{questionUuid}")
    public List<TagResponse> findTagsByQuestionUuid(@PathVariable String questionUuid) {
        return tagService.findTagsByQuestionUuid(questionUuid);
    }

}
