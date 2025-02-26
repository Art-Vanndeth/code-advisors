package co.cstad.contentdiscovery.repository;

import co.cstad.contentdiscovery.domain.Content;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ContentRepository extends ElasticsearchRepository<Content, String> {
}