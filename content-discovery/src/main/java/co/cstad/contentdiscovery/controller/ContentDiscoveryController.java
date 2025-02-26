package co.cstad.contentdiscovery.controller;

import co.cstad.contentdiscovery.domain.Content;
import co.cstad.contentdiscovery.service.ContentDiscoveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentDiscoveryController {

    @Autowired
    private ContentDiscoveryService contentDiscoveryService;

    @GetMapping("/trending")
    public List<Content> getTrendingPosts(@RequestParam(defaultValue = "10") int limit) {
        return contentDiscoveryService.getTrendingPosts(limit);
    }

    @GetMapping("/featured")
    public List<Content> getFeaturedArticles(@RequestParam(defaultValue = "10") int limit) {
        return contentDiscoveryService.getFeaturedArticles(limit);
    }

    @GetMapping("/tag/{tag}")
    public List<Content> getContentByTag(@PathVariable String tag, @RequestParam(defaultValue = "10") int limit) {
        return contentDiscoveryService.getContentByTag(tag, limit);
    }

    @GetMapping("/latest")
    public List<Content> getLatestPosts(@RequestParam(defaultValue = "10") int limit) {
        return contentDiscoveryService.getLatestPosts(limit);
    }

    @GetMapping("/recommended")
    public List<Content> getRecommendedPosts(@RequestParam List<String> interests, @RequestParam(defaultValue = "10") int limit) {
        return contentDiscoveryService.getRecommendedPosts(interests, limit);
    }
    @PostMapping
    public Content createContent(@RequestBody Content content) {
        return contentDiscoveryService.createContent(content);
    }
}

