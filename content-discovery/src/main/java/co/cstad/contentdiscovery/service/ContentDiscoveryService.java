package co.cstad.contentdiscovery.service;

import co.cstad.contentdiscovery.domain.Content;
import co.cstad.contentdiscovery.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ContentDiscoveryService {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    public List<Content> getTrendingPosts(int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit, Sort.by("views").descending());
        return contentRepository.findAll(pageRequest).getContent();
    }

    public List<Content> getFeaturedArticles(int limit) {
        CriteriaQuery query = new CriteriaQuery(
                new Criteria("featured").is(true)
        ).setPageable(PageRequest.of(0, limit));

        SearchHits<Content> searchHits = elasticsearchOperations.search(query, Content.class);
        return searchHits.getSearchHits().stream()
                .map(hit -> hit.getContent())
                .toList();
    }

    public List<Content> getContentByTag(String tag, int limit) {
        CriteriaQuery query = new CriteriaQuery(
                new Criteria("tags").contains(tag)
        ).setPageable(PageRequest.of(0, limit));

        SearchHits<Content> searchHits = elasticsearchOperations.search(query, Content.class);
        return searchHits.getSearchHits().stream()
                .map(hit -> hit.getContent())
                .toList();
    }

    public List<Content> getLatestPosts(int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit, Sort.by("createdDate").descending());
        return contentRepository.findAll(pageRequest).getContent();
    }

    public List<Content> getRecommendedPosts(List<String> userInterests, int limit) {
        CriteriaQuery query = new CriteriaQuery(
                new Criteria("tags").in(userInterests)
        ).setPageable(PageRequest.of(0, limit));

        SearchHits<Content> searchHits = elasticsearchOperations.search(query, Content.class);
        return searchHits.getSearchHits().stream()
                .map(hit -> hit.getContent())
                .toList();
    }
    public Content createContent(Content content) {
        return contentRepository.save(content);
    }
}