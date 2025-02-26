package com.example.forumcodeadvisors.feature.question.repository;

import com.example.forumcodeadvisors.domain.Question;
import com.example.forumcodeadvisors.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    Optional<Question> findByUuid(String uuid);

    Optional<Question> findByUuidAndIsArchivedAndIsDeletedAndIsDrafted(String uuid, Boolean isArchived, Boolean isDeleted, Boolean isDrafted);

    Page<Question> findAllByIsArchivedAndIsDeletedAndIsDrafted(Boolean isArchived, Boolean isDeleted, Boolean isDrafted, Pageable pageable);

    Page<Question> findAllByAuthorUuidAndIsDeletedAndIsDrafted(String authorUuid, Boolean isDeleted, Boolean isDrafted, Pageable pageable);

   Optional<Question> findBySlugAndIsArchivedAndIsDeletedAndIsDrafted(String slug, Boolean isArchived, Boolean isDeleted, Boolean isDrafted);

   Page<Question> findAllByTagsAndIsArchivedAndIsDeletedAndIsDrafted(List<Tag> tags, Boolean isArchived, Boolean isDeleted, Boolean isDrafted, Pageable pageable);

    Page<Question> findAllByAuthorUsernameAndIsArchivedAndIsDeletedAndIsDrafted(String authorUsername, Boolean isDeleted, Boolean isDrafted, Boolean isArchived, Pageable pageable);

   Boolean existsBySlug(String slug);
}
