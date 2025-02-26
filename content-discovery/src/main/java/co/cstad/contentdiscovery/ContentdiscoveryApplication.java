package co.cstad.contentdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "co.cstad.contentdiscovery.repository")
public class ContentdiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentdiscoveryApplication.class, args);
    }

}
