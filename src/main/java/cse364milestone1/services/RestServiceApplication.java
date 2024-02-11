package cse364milestone1.services;

import cse364milestone1.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
    "cse364milestone1.model",
    "cse364milestone1.controllers",
    "cse364milestone1.services",
    "cse364milestone1.jobs",
}, exclude = { DataSourceAutoConfiguration.class })
@EnableMongoRepositories(basePackages = {
    "cse364milestone1.model",
})
public class RestServiceApplication extends SpringBootServletInitializer {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }
}