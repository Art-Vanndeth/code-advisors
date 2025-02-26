package com.example.forumcodeadvisors.feature.tag.mapper;


import com.example.forumcodeadvisors.domain.Tag;
import com.example.forumcodeadvisors.feature.tag.dto.TagResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {

    List<TagResponse> toTagResponse(List<Tag> tags);
}
