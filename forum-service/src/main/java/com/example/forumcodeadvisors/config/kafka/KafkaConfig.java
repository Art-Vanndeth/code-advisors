package com.example.forumcodeadvisors.config.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@RequiredArgsConstructor
public class KafkaConfig {

    // Topic configuration
    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("forum-comment-created-events-topic")
                .partitions(3) // Increased partitions for scalability
                .replicas(1) // Ensure proper replication based on your cluster setup
                .compact() // Compaction is good for retaining only the latest records with the same key
                .build();
    }

    // Topic configuration
    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("forum-created-events-topic")
                .partitions(3) // Increased partitions for scalability
                .replicas(1) // Ensure proper replication based on your cluster setup
                .compact() // Compaction is good for retaining only the latest records with the same key
                .build();
    }

    // Topic configuration
    @Bean
    public NewTopic topic3() {
        return TopicBuilder.name("forum-reply-created-events-topic")
                .partitions(3) // Increased partitions for scalability
                .replicas(1) // Ensure proper replication based on your cluster setup
                .compact() // Compaction is good for retaining only the latest records with the same key
                .build();
    }

}
